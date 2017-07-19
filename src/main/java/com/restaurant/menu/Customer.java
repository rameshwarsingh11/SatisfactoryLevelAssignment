package com.restaurant.menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Customer class. The customer can eat the dishes upto the given time in
 * minutes.
 *
 */
public class Customer {

	/**
	 * Customer constructor.
	 * 
	 * @param customerName
	 * @param totalTimeToEat
	 * @param menu
	 */
	public Customer() {
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
}
