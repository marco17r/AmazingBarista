package view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

    public void menuDisplayPage(String userType, boolean trueMember) 
    {
        Stage displayMenuWindow = new Stage();
        //Instantiating the VBox class
        VBox verticleBoxLayout = new VBox(10);
        Inventory inv = new Inventory();
        Order customerOrder = new Order();
        Text totalPriceText = new Text();
        //Declaration of the submit button
        Button submitButton = new Button("Submit");
        
        //Block events to other windows
        displayMenuWindow.initModality(Modality.APPLICATION_MODAL);
        
        //Setting the margins to the vertical box layout
        verticleBoxLayout.setPadding(new Insets(20, 20, 20, 20));
        verticleBoxLayout.getChildren().add(createDrinkTitle("Drink", "Description", "Price", "Quantity"));
        //Retrieving the observable list of the VBox
        ObservableList list = verticleBoxLayout.getChildren();
        //Adding the Title HBox to the observable list
        //list.add(createDrinkTitle("Drink", "Description", "Price", "Quantity"));
        
        Map<String, Drink> mapOfDrinks = inv.defaultDrinkMenu();

        for (String itemName : mapOfDrinks.keySet()) 
        {
            Drink drinkInfo = mapOfDrinks.get(itemName);
            verticleBoxLayout.getChildren().addAll(createDrinkMenuItems(drinkInfo.getName(), drinkInfo.getDescription(), String.valueOf(drinkInfo.getPrice())));
        }

        for (String drinkName : mapOfAddButtons.keySet()) 
        {
            mapOfAddButtons.get(drinkName).setOnAction(event -> 
            {
                    Drink drink = mapOfDrinks.get(drinkName);
                    BigDecimal itemQuantity = new BigDecimal(mapOfTextInputs.get(drink.getName()).getText());
                    customerOrder.addToOrder(drink, itemQuantity);
                    
                    if(trueMember == true)
                    {
                    	BigDecimal newMemberDivisor = new BigDecimal("2");
                    	BigDecimal newMemberPrice = new BigDecimal(String.valueOf(customerOrder.getOrderTotal().divide(newMemberDivisor)));
                    	totalPriceText.setText(("$" + newMemberPrice));
                    }
                    else
                    {
                    	totalPriceText.setText("$" + String.valueOf(customerOrder.getOrderTotal()));
                    }
            });
        }

        for (String drinkName : mapOfClearButtons.keySet()) 
        {
            mapOfClearButtons.get(drinkName).setOnAction(event -> 
            {
                    customerOrder.clearOrder();
                    totalPriceText.setText(String.valueOf(customerOrder.getOrderTotal()));
            });
        }
        
        //Submit button action event
        submitButton.setOnAction(event -> 
        {
            displayMenuWindow.close();
        });

        verticleBoxLayout.getChildren().addAll();
        //Adding the node to the observable list
        list.addAll(submitButton, totalPriceText);
        
        verticleBoxLayout.setStyle("-fx-background-color: AQUA;");
        //Setting title to the stage.
        displayMenuWindow.setTitle(userType + " Menu Page");
        displayMenuWindow.setMinWidth(1200);
        //displayMenuWindow.setMaxWidth(1000);
        //Creating a scene object
        Scene displayMenuScene = new Scene(verticleBoxLayout);
        //Adding scene to the stage
        displayMenuWindow.setScene(displayMenuScene);
        //Display Menu window and wait for it to be cancelled before returning.
        displayMenuWindow.showAndWait();
    }

    private static HBox createDrinkTitle(String drinkTitle, String descriptionTitle, String priceTitle, String quantityTitle) 
    {
        HBox topHorizontalBox = new HBox();
        topHorizontalBox.getChildren().addAll(new Label(drinkTitle), new Label(descriptionTitle), new Label(priceTitle), new Label(quantityTitle));
        //ObservableList<Node> list = topHorizontalBox.getChildren();
        //Adding the node to the observable list
        //list.addAll(new Label(drinkTitle), new Label(descriptionTitle), new Label(priceTitle), new Label(quantityTitle));
        //Styling Horizontal Box Layout
        topHorizontalBox.setStyle("-fx-background-color:orangered;");
        topHorizontalBox.setSpacing(111);
        topHorizontalBox.setAlignment(Pos.TOP_LEFT);
        
        return topHorizontalBox;
    }

    public HBox createDrinkMenuItems(String drinkTitleItem, String drinkDescriptionItem, String drinkPriceItem) 
    {
        HBox bottomHorizontalBox = new HBox();
        TextField drinkQuality = new TextField();
        Button addToCartButton = new Button("Add To Cart");
        Button clearCartButton = new Button("Clear Cart");
        
        bottomHorizontalBox.getChildren().addAll(new Label(drinkTitleItem), new Label(drinkDescriptionItem), new Label(drinkPriceItem), drinkQuality, addToCartButton, clearCartButton);
        //Retrieving the observable list of the VBox
        //ObservableList list = bottomHorizontalBox.getChildren();
        //Adding the node to the observable list
        //list.addAll(drinkQuality, addToCartButton, clearCartButton);
        
        mapOfTextInputs.put(drinkTitleItem, drinkQuality);
        mapOfAddButtons.put(drinkTitleItem, addToCartButton);
        mapOfClearButtons.put(drinkTitleItem, clearCartButton);
        
        //Styling Horizontal Box Layout  
        addToCartButton.setStyle("-fx-background-color: green; -fx-text-fill: white;"); 
        clearCartButton.setStyle("-fx-background-color: TOMATO; -fx-text-fill: white;"); 
        drinkQuality.setStyle("-fx-font: semi bold 11px 'times new roman' "); 
        
        bottomHorizontalBox.setStyle("-fx-background-color: cyan;");
        bottomHorizontalBox.setSpacing(70);
        bottomHorizontalBox.setAlignment(Pos.CENTER);
        
        return bottomHorizontalBox;
    }
}