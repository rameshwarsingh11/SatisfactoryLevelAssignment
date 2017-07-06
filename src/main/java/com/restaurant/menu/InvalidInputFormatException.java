package com.restaurant.menu;

public class InvalidInputFormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputFormatException() {
	}

	public InvalidInputFormatException(String str) {
		super(str);
	}

	public InvalidInputFormatException(Throwable e) {
		super(e);
	}
}
