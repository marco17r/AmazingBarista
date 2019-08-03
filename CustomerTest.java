package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import model.Customer;

//Constant strings are put in the view;

//test case for the customer class
public class CustomerTest
{
	Customer customerMarco, customerAravind, customerKullen, customerMatthew;
	String nameToSet = "Marquito";
	String passToSet = "Password";
	int typeToSet = 2; 
	
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
	
	@Test
	public final void testSetName() throws Exception
	{
		customerMarco.setName(nameToSet);
		assertEquals(customerMarco.getName(), nameToSet);
	}
	
	@Test
	public final void testGetName() throws Exception
	{
		customerMarco.setName(nameToSet);
		Customer Marco = customerMarco;
		String testName = Marco.getName();
		assertEquals(testName, customerMarco.getName());
	}
	
	@Test
	public final void testSetPass() throws Exception
	{
		customerMarco.setPass(passToSet);
		assertEquals(customerMarco.getPass(), passToSet);
	}
	
	@Test
	public final void testGetPass() throws Exception
	{
		customerMarco.setPass(passToSet);
		Customer Marco = customerMarco;
		String testPass = Marco.getPass();
		assertEquals(testPass, customerMarco.getPass());
	}
	
	@Test
	public final void testSetType() throws Exception
	{
		customerMarco.setType(typeToSet);
		assertEquals(customerMarco.getType(), typeToSet);
	}
	
	@Test
	public final void testGetType() throws Exception
	{
		customerMarco.setType(typeToSet);
		Customer Marco = customerMarco;
		int testType = Marco.getType();
		assertEquals(customerMarco.getType(), testType);
	}
	
	//Constant strings in the view;
}