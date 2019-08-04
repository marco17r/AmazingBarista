package model;

import java.util.ArrayList;
import java.util.List;

public class SippinStop extends Customer 
{
	// Array for Customer objects
	public List<Customer> customerList = new ArrayList<Customer>(5);
	// Array for Transaction objects
	public List<Transaction> transactionList = new ArrayList<Transaction>(5);
	// Array for drinks, Items objects
	public List<Drink> inventory = new ArrayList<Drink>(5);

	private void addMember(Customer customerToAdd) 
	{
		// function to add a new member
		customerList.add(customerToAdd);
	}

	private void removeMember(Customer customerToRemove) 
	{
		// function to remove a member by name
		customerList.remove(customerToRemove);
	}

	private void removeMember(String customerToRemove) 
	{
		// function to remove a member by name
		customerList.remove(customerToRemove);
	}

	private void addTransaction(Transaction transactionToAdd) 
	{
		// function to add transaction to transaction array
		transactionList.add(transactionToAdd);
	}

	private void removeTransaction(Transaction transactionToRemove) 
	{
		// function to remove a transaction from the transaction array
		transactionList.remove(transactionToRemove);
	}

	private void removeTransaction(String transactionToRemove) 
	{
		// function to remove a transaction from the transaction array
		transactionList.remove(transactionToRemove);
	}

	private void removeTransaction(int transactionToRemove) 
	{
		// function to remove a transaction from the transaction array
		transactionList.remove(transactionToRemove);
	}
}