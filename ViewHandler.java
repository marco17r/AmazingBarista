package view;

import model.Drink;
import model.Inventory;
import model.Order;
import view.MenuWindow;
import java.util.Map;
import java.math.BigDecimal;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javax.swing.text.TableView.TableRow;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

 public class ViewHandler
{
	public static String userName;
	public static String userPass;
	public static ObservableList<Object> Menu;


 	//Class for displaying the sign-up window
	public static void displaySignUp()
	{
		Stage signUpWindow = new Stage();
		//Block events to other windows
		signUpWindow.initModality(Modality.APPLICATION_MODAL);
		signUpWindow.setTitle("Member Sign-Up");
		signUpWindow.setMinWidth(250);
		Label newNameLabel = new Label("Name :");
		TextField newNameTextField = new TextField();
		Label newPassLabel = new Label("Password :");
		TextField newPassWordTextField = new TextField();
		//Member Sign-Up button
		Button signUpButton = new Button("Sign-Up");
		signUpButton.setOnAction( e ->
		{
			ViewHandler.userName = (String) newNameTextField.getText();
			ViewHandler.userPass = (String) newPassWordTextField.getText();
			signUpWindow.close();
		});
		//Cancel Sign-Up Button
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(e -> signUpWindow.close());

 		VBox verticleBoxlayout = new VBox(10);
		verticleBoxlayout.setPadding(new Insets(20, 20, 20, 20));
		verticleBoxlayout.getChildren().addAll(newNameLabel, newNameTextField, newPassLabel, newPassWordTextField, signUpButton, cancelButton);
		verticleBoxlayout.setAlignment(Pos.CENTER_LEFT);

 		Scene signUpScene = new Scene(verticleBoxlayout);
		signUpWindow.setScene(signUpScene);
		signUpWindow.showAndWait();
	}


 	//Class for displaying the log-in window
	public static void displayLogIn()
	{
		Stage logInWindow = new Stage();
		//Block events to other windows
		logInWindow.initModality(Modality.APPLICATION_MODAL);
		logInWindow.setTitle("Member Login");
		logInWindow.setMinWidth(250);
		Label NameLabel = new Label("Name :");
		//Text Field for user name input
		TextField userNameTextField = new TextField();
		Label PassLabel = new Label("Password :");
		//Text field for user name password
		TextField userPassWordTextField = new TextField();
		//Member Login Button
		Button logInButton = new Button("Login");
		logInButton.setOnAction( e ->
		{
			ViewHandler.userName = (String) userNameTextField.getText();
			ViewHandler.userPass = (String) userPassWordTextField.getText();
			logInWindow.close();
		});
		//Exit Button
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(e -> logInWindow.close());
		//Display Set-up?
		VBox verticleBoxLayout = new VBox(10);
		verticleBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		verticleBoxLayout.getChildren().addAll(NameLabel, userNameTextField, PassLabel,userPassWordTextField, logInButton, cancelButton);
		verticleBoxLayout.setAlignment(Pos.TOP_LEFT);
		//Display login window and wait for it to be cancelled before returning.
		Scene logInScene = new Scene(verticleBoxLayout);
		logInScene.setFill(Color.GREENYELLOW);
		logInWindow.setScene(logInScene);
		logInWindow.showAndWait();
	}


 	//Class for displaying the Menu for Drinks window
	public static void displayDrinkMenu()
	{
		Stage displayDrinkMenuWindow = new Stage();
		//Block events to other windows
		displayDrinkMenuWindow.initModality(Modality.APPLICATION_MODAL);
		//sets the window title to the parameter argument above
		displayDrinkMenuWindow.setTitle("Drink Menu");
		//sets the minimum width of the drink menu window
		displayDrinkMenuWindow.setMinWidth(250);
		//GameController gc = new GameController();
		//gc.getLeaderBoard();

 		TableColumn <Object, String> drinkNameColumn = new TableColumn<> ("Drink");
		drinkNameColumn.setMinWidth(200);
		drinkNameColumn.setCellValueFactory(new PropertyValueFactory <> ("Drink Name"));

 		TableColumn <Object, String> drinkDescriptionColumn = new TableColumn<> ("Description");
		drinkDescriptionColumn.setMinWidth(200);
		drinkDescriptionColumn.setCellValueFactory(new PropertyValueFactory <> ("Drink Description"));

 		TableColumn <Object, Integer> drinkPriceColumn = new TableColumn<> ("Price");
		drinkPriceColumn.setMinWidth(200);
		drinkPriceColumn.setCellValueFactory(new PropertyValueFactory <> ("Drink price"));

 		//TableRow drinkNameRow0 = new TableRow (null);
		//drinkNameRow0.equals(obj)
		//setCellValueFactory(new PropertyValueFactory <> ("water"));
		
		Inventory inv = new Inventory();
		TableView <Object> drinkMenuTable = new TableView <Object>();
		HBox horizontalBoxLayout = new HBox(10);
        Map<String, Drink> mapOfDrinks = inv.storeDefaultDrinkMenu();

        for (String itemName : mapOfDrinks.keySet()) 
        {
            Drink drink = mapOfDrinks.get(itemName);
            //horizontalBoxLayout.getChildrenUnmodifiable().addAll(createDrinkMenuItems(drink.getName(), drink.getDescription(), String.valueOf(drink.getPrice())));
            //table.setParent(Pos.CENTER_LEFT);
            horizontalBoxLayout.getChildren().addAll(createDrinkMenuItems(drink.getName(), drink.getDescription(), String.valueOf(drink.getPrice())));
        }
 		
		drinkMenuTable.getColumns().add(drinkNameColumn);
		drinkMenuTable.getColumns().add(drinkDescriptionColumn);
		drinkMenuTable.getColumns().add(drinkPriceColumn);
		//drinkMenuTable.getRowFactory().add(horizontalBoxLayout);
		VBox verticleBox = new VBox();
		verticleBox.getChildren().add(drinkMenuTable);

 		Scene drinkMenuScene = new Scene(verticleBox);
		drinkMenuScene.setFill(Color.RED);
		displayDrinkMenuWindow.setScene(drinkMenuScene);
		displayDrinkMenuWindow.show();
	}


 	//Class for displaying the current customer's order
	public static void displayOrder()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		//sets the window title to the parameter argument above
		window.setTitle("Current Order");
		//sets the minimum width of the drink menu window
		window.setMinWidth(250);
		//GameController gc = new GameController();
		//gc.getLeaderBoard();
	}
	
	private static HBox createDrinkMenuItems(String drinkTitleItem, String drinkDescriptionItem, String drinkPriceItem) 
    {
        HBox horizontalBox = new HBox();
        horizontalBox.getChildren().add(new Label(drinkTitleItem));
        //horizontalBox.setSpacing(50.0);
        //horizontalBox.setAlignment(Pos.CENTER_LEFT);
        
        horizontalBox.getChildren().add(new Label(drinkDescriptionItem));
        //horizontalBox.setSpacing(50.0);
        //horizontalBox.setAlignment(Pos.CENTER_LEFT);
        
        horizontalBox.getChildren().add(new Label(drinkPriceItem));
        horizontalBox.setSpacing(50.0);
        horizontalBox.setAlignment(Pos.CENTER);
        return horizontalBox;
    }
} 