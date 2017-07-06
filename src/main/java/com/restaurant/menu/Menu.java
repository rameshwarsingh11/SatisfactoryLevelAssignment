package com.restaurant.menu;

/**
 * Menu class for the source file
 *
 */
public class Menu {

	public MenuItem[] items = new MenuItem[101];

	public Menu() {
		populateMenuItems();
	}

	public void setItemList(MenuItem[] items) {
		this.items = items;
	}

	public MenuItem[] getItemList() {
		return items;
	}

	public void populateMenuItems() {
		MenuItem item;
		// populate Dishes in Item
		for (int i = 0; i <=100; i++) {
			item = new MenuItem(i, "Dish ::  " + i);
			items[i] = item;
		}

	}

}
