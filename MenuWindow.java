package view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Drink;
import model.Inventory;
import model.Order;

public class MenuWindow 
{

    private Map<String, TextField> mapOfTextInputs = new HashMap<>();
    private Map<String, Button> mapOfAddButtons = new HashMap<>();
    private Map<String, Button> mapOfClearButtons = new HashMap<>();

    public void menuDisplayPage(String userType) 
    {
        Stage window = new Stage();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(userType + " Menu Page");
        window.setMinWidth(800);
        window.setMaxWidth(1000);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().add(createDrinkTitle("Drink", "Description", "Price", "Quantity"));
        //layout.setAlignment(Pos.TOP_CENTER);
        Inventory inv = new Inventory();

        Map<String, Drink> mapOfDrinks = inv.storeDefaultDrinkMenu();
        Order customerOrder = new Order();
        Text totalPriceText = new Text();

        for (String itemName : mapOfDrinks.keySet()) 
        {
            Drink drink = mapOfDrinks.get(itemName);
            layout.getChildren().addAll(createDrinkMenuItems(drink.getName(), drink.getDescription(), String.valueOf(drink.getPrice())));
            layout.setAlignment(Pos.CENTER_LEFT);
        }

        for (String drinkName : mapOfAddButtons.keySet()) 
        {
            mapOfAddButtons.get(drinkName).setOnAction(e -> 
            {
                    Drink drink = mapOfDrinks.get(drinkName);
                    BigDecimal itemQuantity = new BigDecimal(mapOfTextInputs.get(drink.getName()).getText());
                    customerOrder.addToOrder(drink, itemQuantity);
                    totalPriceText.setText(String.valueOf(customerOrder.getOrderTotal()));
            });
        }

        for (String drinkName : mapOfClearButtons.keySet()) 
        {
            mapOfClearButtons.get(drinkName).setOnAction(e -> 
            {
                    customerOrder.clearOrder();
                    totalPriceText.setText(String.valueOf(customerOrder.getOrderTotal()));
            });
        }
        

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> 
        {
            window.close();
        });

        layout.getChildren().addAll(submitButton, totalPriceText);
        //layout.setAlignment(Pos.TOP_LEFT);
        //Display login window and wait for it to be cancelled before returning.
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    private static HBox createDrinkTitle(String drinkTitle, String descriptionTitle, String priceTitle, String quantityTitle) 
    {
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label(drinkTitle));
        hbox.setSpacing(400);
        //hbox.setAlignment(Pos.TOP_LEFT);
        hbox.getChildren().add(new Label(descriptionTitle));
        hbox.setSpacing(300);
        //hbox.setAlignment(Pos.TOP_LEFT);
        hbox.getChildren().add(new Label(priceTitle));
        hbox.setSpacing(200);
        //hbox.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().add(new Label(quantityTitle));
        hbox.setSpacing(100);
        hbox.setAlignment(Pos.TOP_LEFT);
        return hbox;
    }

    public HBox createDrinkMenuItems(String drinkTitleItem, String drinkDescriptionItem, String drinkPriceItem) 
    {
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label(drinkTitleItem));
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.CENTER_LEFT);
        
        hbox.getChildren().add(new Label(drinkDescriptionItem));
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.CENTER_LEFT);
        
        hbox.getChildren().add(new Label(drinkPriceItem));
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.CENTER);
        
        TextField quantity = new TextField();
        hbox.getChildren().add(quantity);
        mapOfTextInputs.put(drinkTitleItem, quantity);
        hbox.setSpacing(50.0);
        hbox.setAlignment(Pos.CENTER_RIGHT);

        Button addToCartButton = new Button("Add To Cart");
        hbox.getChildren().add(addToCartButton);
        mapOfAddButtons.put(drinkTitleItem, addToCartButton);

        Button clearCartButton = new Button("Clear Cart");
        hbox.getChildren().add(clearCartButton);
        mapOfClearButtons.put(drinkTitleItem, clearCartButton);
        return hbox;
    }
}
