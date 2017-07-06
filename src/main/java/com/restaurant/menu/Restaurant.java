package com.restaurant.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Problem Statement : Gordon Ramsey, a very smart guy, likes eating food. Now,
 * Gordon is at a restaurant and he has many different types of food to choose
 * from. Gordon gets x amount of satisfaction and requires y amount of time to
 * eat an item from the menu.
 * 
 * Given t minutes, write a java program that reads the text file and finds out
 * the maximum satisfaction that Gordon can get from eating at the restaurant.
 * You will be given a text file with the following format:
 * 
 * [t][Number of items on menu]
 * 
 * [amount of satisfaction from eating dish 1][time taken for dish 1]
 * 
 * [amount of satisfaction from dish 2][time taken for dish 2]
 * 
 */
@SpringBootApplication
public class Restaurant {
	private static Menu menu;
	private static Customer customer;

	/**
	 * Take the time taken from command line. *
	 * 
	 * As of now the time is hard coded for testing.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Restaurant.class, args);
		int time = 0;
		try {
			System.out.println("Customer name :: " + "Gordon");
			System.out.println("Total Time in mins, given to Gordon to eat dishes is ::" + 10000 + " mins");
			time = 10000;
		} catch (NumberFormatException nfe) {
			System.err.println("Number not valid." + nfe.getMessage());
		}
		// Below should be enabled in case of input taken from command line
		/*
		 * catch(ArrayIndexOutOfBoundsException aoe){
		 * System.err.println("invalid input variables.." + aoe.getMessage()); }
		 */
		menu = new Menu();
		customer = new Customer("Gordon", time, menu);
	}
}
