package com.restaurant.menu;

import java.io.InputStream;
import java.util.Scanner;

/**
 * DishEatingHelper implements KnapSack Algorithm to find the max satisfaction
 * for a variety of dishes.
 * 
 * KnapSack problem, which restricts the number xi of copies of each kind of
 * item to zero or one. Given a set of n items numbered from 1 up to n, each
 * with a weight wi and a value vi, along with a maximum weight capacity W
 * 
 *
 */
public class DishEatingHelper {
	Integer readDataFile(InputStream is) {
		// Total allowable time in seconds!
		Integer t = null;
		// Total number of Items on Menu
		Integer n = null;
		// Time required to eat an item
		Integer y[] = null;
		// Degree of Satisfaction
		Integer x[] = null;
		try (Scanner s = new Scanner(is)) {
			t = s.nextInt();
			n = s.nextInt();
			y = new Integer[n];
			x = new Integer[n];
			for (Integer i = 0; i < n; i++) {
				x[i] = s.nextInt();
				y[i] = s.nextInt();
			}
		} catch (Throwable e) {
			throw new InvalidInputFormatException(e);
		}
		return new KnapSackAlgorithm().doKnapSack(t, y, x, n);
	}
}
