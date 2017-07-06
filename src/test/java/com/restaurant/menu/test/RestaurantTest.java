package com.restaurant.menu.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.restaurant.menu.Customer;
import com.restaurant.menu.Menu;
import com.restaurant.menu.MenuItem;

public class RestaurantTest {

	Menu menu;
	Customer customer;
	
	@Before
	public void setUp() throws Exception {
		menu = new Menu();
		customer = new Customer("Gordon", 10000, menu);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		//MenuItem[] finalItems = menu.getItemList();
		Method method = customer.getClass().getDeclaredMethod("findMaxSatisfactoryLevel", MenuItem.class);
		method.setAccessible(true);
		return;
	}

}
