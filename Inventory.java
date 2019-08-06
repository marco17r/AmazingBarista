package model;

public class Inventory extends Drink
{
	//This class defines the inventory of drinks available to users of the app for
	//purchase and use of said drinks
	public enum drinks 
	{
		WATER, LEMONADE, KOMBUCHA, LIMEADE, KOOLADE
	}
	
	//Standard drink inventory Array
	Drink mapOfdrinkss[] = 
	{
			new Drink("Water", "Drinking Water", 0),
			new Drink("Lemonade", "Water with lemon juice and brown sugar", 1),
			new Drink("Kombucha", "Probiotic drink from India, great for gut flora", 4),
			new Drink("Limeade", "Water with lime juice and brown sugar", 1),
			new Drink("Koolade", "Water stirred with Koolade drink mix", 1)
	};
	
	//Default Constructor not necessarily needed yet.
	
	public Drink[] getDrinkOptions()
	{
		return mapOfdrinkss;
	}
}