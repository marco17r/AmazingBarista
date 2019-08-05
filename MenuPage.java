package view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Drink;
import model.Inventory;
import model.Order;

public class MenuPage {

    private Map<String, TextField> mapOfTextInputs = new HashMap<>();

    private Map<String, Button> mapOfAddButtons = new HashMap<>();

    private Map<String, Button> mapOfClearButtons = new HashMap<>();

    public void menuDisplayPage(String userType) {
        Stage window = new Stage();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(userType + " Menu Page");
        window.setMinWidth(800);
        window.setMaxWidth(1000);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        layout.getChildren().add(createDrinkTitle("DRINK NAME", "DRINK DESCRIPTION", "DRINK PRICE", "DRINK QUANTITY"));

        Inventory inv = new Inventory();

        Map<String, Drink> mapOfDrinks = inv.storeDefaultDrinkMenu();
        Order order = new Order();
        Text totalText = new Text();

        for (String itemName : mapOfDrinks.keySet()) {
            Drink drink = mapOfDrinks.get(itemName);
            layout.getChildren().addAll(createDrinkMenuItems(drink.getName(), drink.getDescription(), String.valueOf(drink.getPrice())));
        }

        for (String drinkName : mapOfAddButtons.keySet()) {
            mapOfAddButtons.get(drinkName).setOnAction(e -> {
                    Drink drink = mapOfDrinks.get(drinkName);
                    BigDecimal itemQuantity = new BigDecimal(mapOfTextInputs.get(drink.getName()).getText());
                    order.addToOrder(drink, itemQuantity);
                    totalText.setText(String.valueOf(order.getOrderTotal()));
                }
            );
        }

        for (String drinkName : mapOfClearButtons.keySet()) {
            mapOfClearButtons.get(drinkName).setOnAction(e -> {
                    order.clearOrder();
                    totalText.setText(String.valueOf(order.getOrderTotal()));
                }
            );
        }

        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
            window.close();
        });

        layout.getChildren().addAll(submitButton, totalText);
        //        layout.setAlignment(Pos.TOP_LEFT);
        //Display login window and wait for it to be cancelled before returning.
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    private static HBox createDrinkTitle(String item1, String item2, String item3, String item4) {
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label(item1));
        hbox.setSpacing(300);
        hbox.getChildren().add(new Label(item2));
        hbox.setSpacing(150);
        hbox.getChildren().add(new Label(item3));
        hbox.setSpacing(95);
        hbox.getChildren().add(new Label(item4));
        hbox.setSpacing(90);
        return hbox;
    }

    private HBox createDrinkMenuItems(String item1, String item2, String item3) {
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label(item1));
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.TOP_LEFT);
        hbox.getChildren().add(new Label(item2));
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().add(new Label(item3));
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.TOP_RIGHT);
        TextField quantity = new TextField();
        hbox.getChildren().add(quantity);
        mapOfTextInputs.put(item1, quantity);
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.TOP_RIGHT);

        Button addToCartButton = new Button("Add To Cart");
        hbox.getChildren().add(addToCartButton);
        mapOfAddButtons.put(item1, addToCartButton);

        Button clearCartButton = new Button("Clear Cart");
        hbox.getChildren().add(clearCartButton);
        mapOfClearButtons.put(item1, clearCartButton);
        return hbox;
    }
}
