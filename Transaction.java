package model;

public class Transaction 
{
	private int paymentType;
	private float transactionAmountRecieved;
	private float transactionAmountNeeded;
	private float transactionAmountRemaining;
	private boolean transactionRefunded; // Is set false by default
	private boolean transactionRecieved; // Is set false by default
	
	//Default Constructor
	public void Transaction()
	{
		System.out.println("Generating new blank transaction!");
		paymentType = 0;
		transactionAmountRecieved = 0;
		transactionAmountNeeded = 0;
		transactionAmountRemaining = 0;
		System.out.println("Confirmation of generation of new blank transaction!");
	}
	
	//Constructor with Arguments
	public void Transaction(int transactionPaymentType,float transactionTotal,float transactionPaymentTotal)
	{
		paymentType = transactionPaymentType;
		transactionAmountNeeded = transactionTotal;
		transactionAmountRecieved = transactionPaymentTotal;
		transactionAmountRemaining = transactionTotal - transactionPaymentTotal;
		System.out.println("Confirmation of generation of the new transaction!");
	}
	//Accessor method for getting the transaction payment Type
	public int getTransactionPaymentType()
	{
		System.out.println("Retrieving the transaction payment type :" + paymentType);
		return paymentType;
	}
	//Mutator method for setting a User Name
	public void setTransactionPaymentType(int paymentTypeToSet)
	{
		System.out.println("Setting the transaction payment type to :" + paymentTypeToSet);
		paymentType = paymentTypeToSet;
		System.out.println("Confirmation of setting the transaction payment type to :" + paymentType);
	}
	//Accessor method for getting the transaction amount recieved
	public float getTransactionAmountRecieved()
	{
		System.out.println("Retrieving the transaction amount recieved :" + transactionAmountRecieved);
		return transactionAmountRecieved;
	}
	//Mutator method for setting the transaction amount recieved
	public void setTransactionAmountRecieved(float transactionAmountRecievedToSet)
	{
		System.out.println("Setting the transaction amount recieved to :" + transactionAmountRecievedToSet);
		transactionAmountRecieved = transactionAmountRecievedToSet;
		System.out.println("Confirmation of setting the transaction amount recieved to :" + transactionAmountRecieved);
	}
	//Accessor method for getting the transaction amount still needed
	public float getTransactionAmountNeeded()
	{
		System.out.println("Retrieving the transaction amount needed :" + transactionAmountNeeded);
		return transactionAmountNeeded;
	}
	//Mutator method for setting the transaction amount still needed
	public void setTransactionAmountNeeded(float transactionAmountNeededToSet)
	{
		System.out.println("Setting the transaction amount needed to :" + transactionAmountNeededToSet);
		transactionAmountNeeded = transactionAmountNeededToSet;
		System.out.println("Confirmation of setting the transaction amount needed to :" + transactionAmountNeeded);
	}
	//Accessor method for getting the remaining transaction amount
	public float getTransactionAmountRemaining()
	{
		System.out.println("Retrieving the remaining transaction amount :" + transactionAmountRemaining);
		return transactionAmountRemaining;
	}
	//Mutator method for setting the remaining transaction amount
	public void setTransactionAmountRemaining(float transactionAmountRemainingToSet)
	{
		System.out.println("Setting the remaining transaction amount to :" + transactionAmountRemainingToSet);
		transactionAmountRemaining = transactionAmountRemainingToSet;
		System.out.println("Confirmation of setting the remaing transaction amount to :" + transactionAmountRemaining);
	}
	//Method for confirming that the transaction amount and payment amount are the same!
	public boolean paymentReceived()
	{
		transactionRecieved = true;
		return transactionRecieved;
	}
	
	void refund()
	{
		isRefunded();
		
	}
	
	boolean isRefunded()
	{
		transactionRefunded = true;
		return transactionRefunded;
	}
}
