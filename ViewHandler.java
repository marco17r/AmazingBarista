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
		Stage window = new Stage();
		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Member Sign-Up");
		window.setMinWidth(250);
		Label newNameLabel = new Label("Name :");
		TextField newNameInput = new TextField();
		Label newPassLabel = new Label("Password :");
		TextField newPassWordInput = new TextField();
		//Member Sign-Up button
		Button signUpButton = new Button("Sign-Up");
		signUpButton.setOnAction( e ->
		{
			ViewHandler.userName = (String) newNameInput.getText();
			ViewHandler.userPass = (String) newPassWordInput.getText();
			window.close();
		});
		//Cancel Sign-Up Button
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(e -> window.close());

 		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(newNameLabel, newNameInput, newPassLabel, newPassWordInput, signUpButton, cancelButton);
		layout.setAlignment(Pos.CENTER_LEFT);

 		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}


 	//Class for displaying the log-in window
	public static void displayLogIn()
	{
		Stage window = new Stage();
		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Member Login");
		window.setMinWidth(250);
		Label NameLabel = new Label("Name :");
		//Text Field for user name input
		TextField userNameInput = new TextField();
		Label PassLabel = new Label("Password :");
		//Text field for user name password
		TextField userPassWordInput = new TextField();
		//Member Login Button
		Button logInButton = new Button("Login");
		logInButton.setOnAction( e ->
		{
			ViewHandler.userName = (String) userNameInput.getText();
			ViewHandler.userPass = (String) userPassWordInput.getText();
			window.close();
		});
		//Exit Button
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(e -> window.close());
		//Display Set-up?
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(NameLabel, userNameInput, PassLabel,userPassWordInput, logInButton, cancelButton);
		layout.setAlignment(Pos.TOP_LEFT);
		//Display login window and wait for it to be cancelled before returning.
		Scene scene = new Scene(layout);
		scene.setFill(Color.GREENYELLOW);
		window.setScene(scene);
		window.showAndWait();
	}


 	//Class for displaying the Menu for Drinks window
	public static void displayDrinkMenu()
	{
		Stage window = new Stage();
		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		//sets the window title to the parameter argument above
		window.setTitle("Drink Menu");
		//sets the minimum width of the drink menu window
		window.setMinWidth(250);
		//GameController gc = new GameController();
		//gc.getLeaderBoard();

 		TableColumn <Object, String> drinkNameColumn = new TableColumn<> ("Drink");
		drinkNameColumn.setMinWidth(200);
		drinkNameColumn.setCellValueFactory(new PropertyValueFactory <> ("drink Name"));

 		TableColumn <Object, String> drinkDescriptionColumn = new TableColumn<> ("Description");
		drinkDescriptionColumn.setMinWidth(200);
		drinkDescriptionColumn.setCellValueFactory(new PropertyValueFactory <> ("playerName"));

 		TableColumn <Object, Integer> drinkPriceColumn = new TableColumn<> ("Price");
		drinkPriceColumn.setMinWidth(200);
		drinkPriceColumn.setCellValueFactory(new PropertyValueFactory <> ("drink price"));

 		//TableRow <Object, Integer> drinkNameRow0 = new TableRow<> ("Water");
		//drinkNameRow0.setMinWidth(200);
		//drinkNameRow0.setCellValueFactory(new PropertyValueFactory <> ("water"));
		
		Inventory inv = new Inventory();
		TableView <Object> table = new TableView <Object>();
		HBox layout = new HBox(10);
        Map<String, Drink> mapOfDrinks = inv.storeDefaultDrinkMenu();

        for (String itemName : mapOfDrinks.keySet()) 
        {
            Drink drink = mapOfDrinks.get(itemName);
            layout.getChildrenUnmodifiable().addAll(createDrinkMenuItems(drink.getName(), drink.getDescription(), String.valueOf(drink.getPrice())));
            //table.setParent(Pos.CENTER_LEFT);
        }
 		
		table.getColumns().add(drinkNameColumn);
		table.getColumns().add(drinkDescriptionColumn);
		table.getColumns().add(drinkPriceColumn);
		VBox vbox = new VBox();
		vbox.getChildren().add(table);

 		Scene scene = new Scene(vbox);
		scene.setFill(Color.RED);
		window.setScene(scene);
		window.show();
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
        return hbox;
    }
} 