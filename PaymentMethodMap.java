package model;

public class PaymentMethodMap
{
	//Standard Payment Method Array
	PaymentMethod mapOfPaymentMethods[] = 
	{
			new PaymentMethod(0,"No payment", 0),
			new PaymentMethod(1,"Cash payment", 0),
			new PaymentMethod(2,"Paper Check", 0),
			new PaymentMethod(3,"Visa Card", 0),
			new PaymentMethod(4,"Master Card", 0),
			new PaymentMethod(5,"Discovery Card", 0),
			new PaymentMethod(6,"AMEX", 0),
	};
	
	//Default Constructor not necessarily needed yet.
	public void PaymentMethodMap()
	{
		//left unimplemented
	}
	//Accessor function for getting the payment method map.
	public PaymentMethod[] getPaymentMethodMap()
	{
		System.out.println("Retrieving Payment Method Map!");
		return mapOfPaymentMethods;
	}
	//Accessor method for getting the payment method used from a provided Payment Method Type variable.
	public String getPaymentMethod(int userPaymentMethodType)
	{
		for(int i = 0; i < mapOfPaymentMethods.length; i++)
		{
			if(userPaymentMethodType == mapOfPaymentMethods[i].getPaymentMethodType())
				return mapOfPaymentMethods[i].getPaymentMethodName();
		}
		System.out.println("Payment Method not found!");
		return mapOfPaymentMethods[0].getPaymentMethodName();
	}
	
}