package model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class Inventory extends Drink {

    //This class defines the inventory of drinks available to users of the app for
    //purchase and use of said drinks
    public enum DRINKS {
        WATER, LEMONADE, KOMBUCHA, LIMEADE, KOOLADE
    }

    public Map<String, Drink> mapOfDrinks = new TreeMap<>();

    public Map<String, Drink> storeDefaultDrinkMenu() {
        mapOfDrinks.put("Normal Drinking Water", new Drink("Normal Warm Drinking Water", "Drinking Water", new BigDecimal("0.0")));
        mapOfDrinks.put("Lemonade", new Drink("Lemonade", "Water with lemon juice and brown sugar", new BigDecimal("1.0")));
        mapOfDrinks.put("Kombucha", new Drink("Kombucha", "Probiotic drink from India, great for gut flora", new BigDecimal("4.0")));
        mapOfDrinks.put("Limeade", new Drink("Limeade", "Water with lime juice and brown sugar", new BigDecimal("1.0")));
        mapOfDrinks.put("Koolade", new Drink("Koolade", "Water stirred with Koolade drink mix", new BigDecimal("1.0")));
        return mapOfDrinks;
    }

        public void addNewDrink(Drink drink){
            mapOfDrinks.put(drink.getName(), drink);
        }

        public Drink getDrinkFromName(String drinkName){
            return mapOfDrinks.get(drinkName);
        }
}