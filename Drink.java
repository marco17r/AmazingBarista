package model;

import java.math.BigDecimal;

public class Drink 
{

	// name of drink
	private String name;
	// drink's description
	private String description;
	// drink's price
	private BigDecimal price;

	// Default Constructor without arguments
	// generation of sample item:
	public Drink() 
	{
		name = "AbstractDrink";
		System.out.println("Generating the following drink: " + name);
		description = "Example Drink Item Generated";
		price = new BigDecimal("0.0");
		System.out.println("Confirmation of generation of the following drink: " + name);
	}

	//Overloaded Constructor with parameter arguments
	public Drink(String drinkName, String drinkDescription, BigDecimal drinkPrice) 
	{
		name = drinkName;
		System.out.println("Generating the following drink: " + drinkName);
		description = drinkDescription;
		price = drinkPrice;
		System.out.println("Confirmation of generation of the following drink: " + drinkName);
	}
	//Mutator Method for setting a drink's name.
	public void setName(String nameToSet) 
	{
		System.out.println("Setting the drink name too : " + nameToSet);
		name = nameToSet;
		System.out.println("Confirmation for setting the drink name too : " + nameToSet);
	}
	//Accessor Method to get a drink's name.
	public String getName() 
	{
		System.out.println("Retrieving the name of the drink :" + name);
		return name;
	}
	//Mutator Method for setting a drink's description.
	public void setDescription(String descriptionToSet) 
	{
		System.out.println("Setting the drink description too : " + descriptionToSet);
		description = descriptionToSet;
		System.out.println("Confirmation for setting the drink description too : " + descriptionToSet);
	}
	//Accessor Method to get a drink's description.
	public String getDescription() 
	{
		System.out.println("Retrieving the description of the drink :" + description);
		return description;
	}
	//Mutator Method for setting a drink's price.
	public void setPrice(BigDecimal priceToSet) 
	{
		System.out.println("Setting the drink price too : " + priceToSet);
		price = priceToSet;
		System.out.println("Confirmation for setting the drink price too : " + priceToSet);
	}
	//Accessor Method to get a drink's price.
	public BigDecimal getPrice() 
	{
		System.out.println("Retrieving the price of the drink :" + price);
		return price;
	}
}