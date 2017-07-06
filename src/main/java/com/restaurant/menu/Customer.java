package com.restaurant.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Customer class. The customer can eat the dishes upto the given time in
 * minutes.
 *
 */
public class Customer {

	private String customerName = null;
	private int totalTimeToEat;
	private int sumTimeToEatAllItem = 0;
	private Boolean isTimeOver = Boolean.FALSE;
	private Menu menu = null;

	/**
	 * Customer constructor.
	 * 
	 * @param customerName
	 * @param totalTimeToEat
	 * @param menu
	 */
	public Customer(String customerName, int totalTimeToEat, Menu menu) {
		this.customerName = customerName;
		this.totalTimeToEat = totalTimeToEat * 60;
		this.menu = menu;

		findtotalItemsToEat();
	}

	/**
	 * method to find total items to eat.
	 * 
	 * @return 1.
	 * @throws Exception
	 */
	private int findtotalItemsToEat() {
		DishEatingHelper dishEatingHelper = new DishEatingHelper();
		File dataFile = new File("..//data.txt");
		try (InputStream stream = new FileInputStream(dataFile)) {
			return dishEatingHelper.readDataFile(stream);
		} catch (IOException e) {
			throw new InvalidInputFormatException();
		}
	}

	private void printAllSatisfactoryLimit() {
		MenuItem[] finalItems = menu.getItemList();

		findMaxSatisfactoryLevel(finalItems);

	}

	/**
	 * Sort the Item array with the help of customized comparator class.
	 * 
	 * Identifies the max satisfactory Level that consumer has experienced with
	 * the particular dish item.
	 * 
	 * @param itemList
	 */
	private void findMaxSatisfactoryLevel(MenuItem[] itemList) {
		Arrays.sort(itemList, new SatisfactoryComparator());
		System.out.print("[ ");
		for (int j = 0; j < itemList.length; j++) {
			System.out.print(itemList[j].getSatisfactoryLimit() + " ");
		}
		System.out.print(" ]");
		System.out.println();
		System.out.println(customerName + " had " + " max satisfaction level " + itemList[0].getSatisfactoryLimit()
				+ " for '" + itemList[0].getName() + "' in Menu list ");
		System.out.println(
				"And Total satisfaction level he got in the given time is :" + totalMaxSatisfactionLevel(itemList));
	}

	/**
	 * method to calculate total satisfaction level achieved in the given time
	 * limit.
	 * 
	 * @param itemList
	 * @return
	 */
	private long totalMaxSatisfactionLevel(MenuItem[] itemList) {
		long totalSatisfactionLevel = 0;
		for (int i = 0; i < itemList.length; i++) {
			totalSatisfactionLevel += itemList[i].getSatisfactoryLimit();
		}
		return totalSatisfactionLevel;
	}

	/**
	 * Method to read dish time and satisfaction factor from the source file.
	 */
	private void readDataFromTextFile() {

		BufferedReader br = null;
		FileReader reader = null;
		int itemCount = 0;
		try {
			reader = new FileReader(new File("..//data.txt"));
			br = new BufferedReader(reader);
			String line;
			while ((line = br.readLine()) != null) {
				if (!isTimeOver) {
					tokenizeLine(line, itemCount);
					itemCount++;
				} else {
					break;
				}
			}
			// Below sets the total items consumed in the list.
			menu.setItemList(Arrays.copyOf(menu.getItemList(), itemCount - 1));

		} catch (IOException e) {
			System.err.println("IOException. Unable to reacd the source file " + e.getStackTrace());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				System.err.println("IOException. unable to terminate. " + ex.getStackTrace());
			}
		}
	}

	/**
	 * Method to read the items in tokenized form.
	 * 
	 * @param data
	 * @param itemCount
	 */
	private void tokenizeLine(String data, int itemCount) {

		// itemCount = itemCount + 1;
		int timeTakenPerDish = 0;
		StringTokenizer tokens = new StringTokenizer(data, " ");

		/*
		 * menu.getItemList()[itemCount].setSatisfactoryLimit(Integer.parseInt(
		 * tokens.nextToken()));
		 */
		if (tokens.hasMoreElements()) {
			menu.getItemList()[itemCount].setSatisfactoryLimit(Integer.parseInt(tokens.nextToken()));
			timeTakenPerDish = Integer.parseInt(tokens.nextToken());
			menu.getItemList()[itemCount].setTimeTaken(timeTakenPerDish);
		}
		sumTimeToEatAllItem = sumTimeToEatAllItem + timeTakenPerDish;
		if (sumTimeToEatAllItem > totalTimeToEat) {
			isTimeOver = Boolean.TRUE;
			return;
		}
		System.out.println(customerName + " ate " + menu.getItemList()[itemCount].getName() + " in time "
				+ menu.getItemList()[itemCount].getTimeTaken() + " secs " + " . His satisfactory level got to "
				+ menu.getItemList()[itemCount].getSatisfactoryLimit());
	}
}
