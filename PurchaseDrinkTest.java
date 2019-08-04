package test;

import org.junit.*;

import model.Customer;

//Constant strings in the view;

//test case for ordering drinks, creating customer and picking out specific drinks
public class PurchaseDrinkTest
{
	Customer customerMarco, customerAravind, customerKullen, customerMatthew;
	
	@Before
	public void setUp() throws Exception
	{
		customerMarco = new Customer("Marco R","Password", 2);
		customerAravind = new Customer("Aravind R","Password", 1);
		customerKullen = new Customer("Kullen L","Password", 0);
		customerMatthew = new Customer("Matthew S","Password", 3);
	}

	@After
	public void tearDown() throws Exception 
	{
		customerMarco = null; 
		customerAravind = null; 
		customerKullen = null;
		customerMatthew = null;
	}
}