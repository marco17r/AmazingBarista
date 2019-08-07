package model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

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
			new Drink("Water", "Drinking Water", new BigDecimal("0.0")),
			new Drink("Lemonade", "Water with lemon juice and brown sugar", new BigDecimal("1.0")),
			new Drink("Kombucha", "Probiotic drink from India, great for gut flora", new BigDecimal("4.0")),
			new Drink("Limeade", "Water with lime juice and brown sugar", new BigDecimal("1.0")),
			new Drink("Koolade", "Water stirred with Koolade drink mix", new BigDecimal("2.0"))
	};
	
	public Map<String,Drink> mapOfDrinks = new TreeMap<>();
	
	public Map<String,Drink> defaultDrinkMenu()
	{
		mapOfDrinks.put("Water", new Drink("Water", "Drinking Water", new BigDecimal("0.0")));
		mapOfDrinks.put("Lemonade", new Drink("Lemonade", "Water with lemon juice and brown sugar", new BigDecimal("1.0")));
        mapOfDrinks.put("Kombucha", new Drink("Kombucha", "Probiotic drink from India, great for gut flora", new BigDecimal("4.0")));
        mapOfDrinks.put("Limeade", new Drink("Limeade", "Water with lime juice and brown sugar", new BigDecimal("1.0")));
        mapOfDrinks.put("Koolade", new Drink("Koolade", "Water stirred with Koolade drink mix", new BigDecimal("1.0")));
        return mapOfDrinks;
	}
	
	//Mutator to add new drinks to the default drink menu.
	public void addNewDrink(Drink drinkObject)
	{
        mapOfDrinks.put(drinkObject.getName(), drinkObject);
    }
	
	//Accessor Method to get drink info from the default drink menu.
    public Drink getDrinkFromName(String drinkObjectName)
    {
        return mapOfDrinks.get(drinkObjectName);
    }
}