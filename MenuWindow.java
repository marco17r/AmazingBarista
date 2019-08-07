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

    public void menuDisplayWindow(String userType) 
    {
        Stage displayMenuWindow = new Stage();
        //Block events to other windows
        displayMenuWindow.initModality(Modality.APPLICATION_MODAL);
        displayMenuWindow.setTitle(userType + " Menu Page");
        displayMenuWindow.setMinWidth(1000);
        displayMenuWindow.setMaxWidth(1200);

        BorderPane menuDisplayBPane = new BorderPane();
        menuDisplayBPane.setPadding(new Insets(20, 20, 20, 20));
        menuDisplayBPane.getChildren().add(createDrinkTitle("Drink", "Description", "Price", "Quantity"));
        //layout.setAlignment(Pos.TOP_CENTER);
        Inventory inv = new Inventory();

        Map<String, Drink> mapOfDrinks = inv.storeDefaultDrinkMenu();
        Order customerOrder = new Order();
        Text totalPriceText = new Text();

        for (String itemName : mapOfDrinks.keySet()) 
        {
            Drink drink = mapOfDrinks.get(itemName);
            menuDisplayBPane.getChildren().addAll(createDrinkMenuItems(drink.getName(), drink.getDescription(), String.valueOf(drink.getPrice())));
            //verticleBoxLayOut.setAlignment(Pos.CENTER_LEFT);
        }

        for (String drinkName : mapOfAddButtons.keySet()) 
        {
            mapOfAddButtons.get(drinkName).setOnAction(e -> 
            {
                    Drink drink = mapOfDrinks.get(drinkName);
                    BigDecimal itemQuantity = new BigDecimal(mapOfTextInputs.get(drink.getName()).getText());
                    customerOrder.addToOrder(drink, itemQuantity);
                    totalPriceText.setText("$" + String.valueOf(customerOrder.getOrderTotal()));
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
            displayMenuWindow.close();
        });

        menuDisplayBPane.getChildren().addAll(submitButton, totalPriceText);
        //layout.setAlignment(Pos.TOP_LEFT);
        //Display login window and wait for it to be cancelled before returning.
        Scene menuDisplayScene = new Scene(menuDisplayBPane);
        displayMenuWindow.setScene(menuDisplayScene);
        displayMenuWindow.showAndWait();
    }

    private static HBox createDrinkTitle(String drinkTitle, String descriptionTitle, String priceTitle, String quantityTitle) 
    {
        HBox horizontalBox = new HBox();
        horizontalBox.getChildren().add(new Label(drinkTitle));
        horizontalBox.getChildren().add(new Label(descriptionTitle));
        horizontalBox.getChildren().add(new Label(priceTitle));
        horizontalBox.getChildren().add(new Label(quantityTitle));
        horizontalBox.setSpacing(111);
        horizontalBox.setAlignment(Pos.TOP_LEFT);
        return horizontalBox;
    }

    @SuppressWarnings("restriction")
	public BorderPane createDrinkMenuItems(String drinkTitleItem, String drinkDescriptionItem, String drinkPriceItem) 
    {
    	BorderPane bPane = new BorderPane();
    	HBox horizontalLabelBox = new HBox();
        horizontalLabelBox.getChildren().add(new Label(drinkTitleItem));
        horizontalLabelBox.getChildren().add(new Label(drinkDescriptionItem));
        horizontalLabelBox.getChildren().add(new Label(drinkPriceItem));
        bPane.getChildren().add(horizontalLabelBox);
        
        
        TextField quantity = new TextField();
        bPane.getChildren().add(quantity);
        mapOfTextInputs.put(drinkTitleItem, quantity);
        
        HBox horizontalButtonBox = new HBox();
        Button addToCartButton = new Button("Add To Cart");
        horizontalButtonBox.getChildren().add(addToCartButton);
        mapOfAddButtons.put(drinkTitleItem, addToCartButton);

        Button clearCartButton = new Button("Clear Cart");
        horizontalButtonBox.getChildren().add(clearCartButton);
        bPane.getChildren().add(horizontalButtonBox);
        mapOfClearButtons.put(drinkTitleItem, clearCartButton);
        
        //Styling nodes  
        bPane.setLeft(horizontalLabelBox);
        bPane.setCenter(quantity);
        bPane.setRight(horizontalButtonBox);
        addToCartButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        clearCartButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        quantity.setStyle("-fx-font: semi bold 11px 'times new roman' "); 
        horizontalLabelBox.setStyle("-fx-background-color:BEIGE;");
        return bPane;
    }
}
