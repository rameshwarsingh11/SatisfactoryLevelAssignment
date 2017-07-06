package com.restaurant.menu;

/**
 * POJO for dishes
 *
 */
public class MenuItem {

	private int id;

	private String name;

	private int satisfactoryLimit;

	private int timeTaken;

	public MenuItem(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public int getSatisfactoryLimit() {
		return satisfactoryLimit;
	}

	public void setSatisfactoryLimit(int satisfactoryLimit) {
		this.satisfactoryLimit = satisfactoryLimit;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
