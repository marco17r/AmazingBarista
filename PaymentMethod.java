package model;

public class PaymentMethod 
{
	private int paymentMethodType;
	private String paymentMethodName;
	private double paymentMethodAmount;
	
	//default constructor
	public PaymentMethod()
	{
		paymentMethodType = 0;
		paymentMethodName = "No payment method used";
		paymentMethodAmount = 0.0;
	}
	//Constructor with arguments
	public PaymentMethod(int typeOfPaymentMethod, String nameOfPaymentMethod, double amountByPaymentMethod)
	{
		paymentMethodType = typeOfPaymentMethod;
		paymentMethodName = nameOfPaymentMethod;
		paymentMethodAmount = amountByPaymentMethod;
	}
	//Accessor Method for getting the Payment Method Type variable
	public int getPaymentMethodType()
	{
		System.out.println("Retrieving payment method type!");
		return paymentMethodType;
	}
	//Accessor Method for getting the Payment Method Name variable
	public String getPaymentMethodName()
	{
		System.out.println("Retrieving payment method used!");
		return paymentMethodName;
	}
	//Accessor Method for getting the Payment Method Amount variable
	public double getPaymentMethodAmount()
	{
		System.out.println("Retrieving amount used by this payment method!");
		return paymentMethodAmount;
	}
}
