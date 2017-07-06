package com.restaurant.menu;

import java.util.Comparator;

/**
 * SatisfactoryComparator class to compare the satisfactory level of two dishes.
 *
 */
public class SatisfactoryComparator implements Comparator<MenuItem> {

	@Override
	public int compare(MenuItem o1, MenuItem o2) {
		// Sorting in highest order. ( descending )
		return o2.getSatisfactoryLimit() - o1.getSatisfactoryLimit();
	}

}
