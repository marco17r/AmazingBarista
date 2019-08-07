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
import javafx.scene.control.Label;
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
		//Window set up and set to blocking events to other windows
		signUpWindow.initModality(Modality.APPLICATION_MODAL);
		signUpWindow.setTitle("Member Sign-Up");
		signUpWindow.setMinWidth(250);
		
		Label newNameLabel = new Label("Name :");
		TextField newNameTextField = new TextField();
		Label newPassLabel = new Label("Password :");
		PasswordField newUserPassWordTextField = new PasswordField();
		
		//Member Sign-Up button
		Button signUpButton = new Button("Sign-Up");
		signUpButton.setOnAction(event ->
		{
			ViewHandler.userName = (String) newNameTextField.getText();
			ViewHandler.userPass = (String) newUserPassWordTextField.getText();
			signUpWindow.close();
		});
		
		//Cancel Sign-Up Button
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(e -> signUpWindow.close());
		
		VBox verticleBoxLayout = new VBox(10);
		verticleBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		verticleBoxLayout.getChildren().addAll(newNameLabel, newNameTextField, newPassLabel, newUserPassWordTextField, signUpButton, cancelButton);
		verticleBoxLayout.setAlignment(Pos.CENTER_LEFT);
		
		Scene signUpScene = new Scene(verticleBoxLayout);
		signUpWindow.setScene(signUpScene);
		//Display login window and wait for it to be cancelled before returning.
		signUpWindow.showAndWait();
	}
	
	
	//Class for displaying the log-in window
	public static void displayLogIn()
	{
		Stage logInWindow = new Stage();
		//Window set up and set to blocking events to other windows
		logInWindow.initModality(Modality.APPLICATION_MODAL);
		logInWindow.setTitle("Member Login");
		logInWindow.setMinWidth(250);
		
		Label NameLabel = new Label("Name :");
		//Text Field for user name input
		TextField userNameTextField = new TextField();
		Label PassLabel = new Label("Password :");
		//Text field for user name password
		PasswordField userPassWordTextField = new PasswordField();
		
		//Member Login Button
		Button logInButton = new Button("Login");
		logInButton.setOnAction(event ->
		{
			ViewHandler.userName = (String) userNameTextField.getText();
			ViewHandler.userPass = (String) userPassWordTextField.getText();
			logInWindow.close();
		});
		
		//Cancel Button
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(event -> logInWindow.close());
		
		//Display Set-up?
		VBox verticleDisplayBoxLayout = new VBox(10);
		verticleDisplayBoxLayout.setPadding(new Insets(20, 20, 20, 20));
		verticleDisplayBoxLayout.getChildren().addAll(NameLabel, userNameTextField, PassLabel,userPassWordTextField, logInButton, cancelButton);
		verticleDisplayBoxLayout.setAlignment(Pos.TOP_LEFT);
		
		
		Scene logInScene = new Scene(verticleDisplayBoxLayout);
		logInScene.setFill(Color.GREENYELLOW);
		logInWindow.setScene(logInScene);
		//Display login window and wait for it to be cancelled before returning.
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
		//Good place to place the controller
		//GameController gc = new GameController();
		//gc.getLeaderBoard();
		
		TableColumn <Object, String> drinkNameColumn = new TableColumn<> ("Drink");
		drinkNameColumn.setMinWidth(200);
		drinkNameColumn.setCellValueFactory(new PropertyValueFactory <> ("drink Name"));
		//drinkNameColumn.
		TableColumn <Object, String> drinkDescriptionColumn = new TableColumn<> ("Description");
		drinkDescriptionColumn.setMinWidth(200);
		drinkDescriptionColumn.setCellValueFactory(new PropertyValueFactory <> ("playerName"));
		
		TableColumn <Object, Integer> drinkPriceColumn = new TableColumn<> ("Price");
		drinkPriceColumn.setMinWidth(200);
		drinkPriceColumn.setCellValueFactory(new PropertyValueFactory <> ("drink price"));
	    
		//TableCell <String> drinkNameRow0 = new TableCell<> ("Water");
		//drinkNameRow0.setMinWidth(200);
		//drinkNameRow0.setCellValueFactory(new PropertyValueFactory <> ("water"));
		
		TableView <Object> drinkMenuTable = new TableView<>();
		//table.setItems(leaderboard);
		drinkMenuTable.getColumns().add(drinkNameColumn);
		drinkMenuTable.getColumns().add(drinkDescriptionColumn);
		drinkMenuTable.getColumns().add(drinkPriceColumn);
		VBox verticleBox = new VBox();
		verticleBox.getChildren().add(drinkMenuTable);
		
		Scene displayDrinkMenuScene = new Scene(verticleBox);
		displayDrinkMenuScene.setFill(Color.RED);
		displayDrinkMenuWindow.setScene(displayDrinkMenuScene);
		displayDrinkMenuWindow.show();
	}
	
	
	//Class for displaying the current customer's order
	public static void displayFinishedOrder()
	{
		Stage displayOrderWindow = new Stage();
		//Block events to other windows
		displayOrderWindow.initModality(Modality.APPLICATION_MODAL);
		//sets the window title
		displayOrderWindow.setTitle("Order Complete");
		//sets the minimum width of the drink menu window
		displayOrderWindow.setMinWidth(250);
		Text closingMessage = new Text("Enjoy your drink(s)! Come back again!");
		VBox verticalBoxLayout = new VBox();
		verticalBoxLayout.getChildren().add(closingMessage);
		Scene scene = new Scene(verticalBoxLayout);
		displayOrderWindow.setScene(scene);
		displayOrderWindow.show();
	}
}