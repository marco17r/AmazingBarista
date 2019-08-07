package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.Color;
import java.awt.Paint;
import java.awt.color.*;

//Class displays the main window
public class StartUpWindow extends Application
{
	Stage startUpWindow;
	
	//Initializes the application
	//@param stage
	
	@Override
	public void start(Stage initStage) throws Exception 
	{
		startUpWindow = initStage;
		//Sets the title of the start up window
		
		startUpWindow.setOnCloseRequest(event ->
		{
			event.consume();
		});
		
		//Button declarations for the start up page
		Button memberLoginButton = new Button("Membership Login");
		Button memberSignInButton = new Button("Membership Sign-Up");
		Button guestLoginButton = new Button("Guest Order");
		Button drinkMenuButton = new Button("Drink Menu");
		Button exitButton = new Button("Exit");
		
		//Declare an horizontal box to put buttons in
		HBox horizontalButtonBox = new HBox();
		//Retrieving the observable list of buttons getting added to the HBox
		ObservableList list = horizontalButtonBox.getChildren();
		//Adding all the nodes to the observable list
		list.addAll(memberLoginButton, memberSignInButton, guestLoginButton, drinkMenuButton, exitButton);
		//Aligns the button box to the bottom center of the screen
		horizontalButtonBox.setAlignment(Pos.BOTTOM_CENTER);
		
		BorderPane bp = new BorderPane();
		bp.setId("StartUpWindow");
		bp.setCenter(horizontalButtonBox);
		
		//Styling Button Objects
		memberSignInButton.setStyle("-fx-background-color: orangered; -fx-text-fill: white;"); 
		memberLoginButton.setStyle("-fx-background-color: navy; -fx-text-fill: white;"); 
		guestLoginButton.setStyle("-fx-background-color: magenta; -fx-text-fill: white;"); 
		drinkMenuButton.setStyle("-fx-background-color: red; -fx-text-fill: white;"); 
		exitButton.setStyle("-fx-background-color: indigo; -fx-text-fill: white;"); 
		  
	    horizontalButtonBox.setStyle("-fx-background-color: aqua;"); 
		
	    //Creating a scene object
		Scene startUpScene =  new Scene(bp, 700, 353);
		//startUpScene.getStylesheets().add("displayStyle.css");
		//Sets the title of the start up window
		startUpWindow.setTitle("Amazing Barista!");
		//Adding the scene to the stage
		startUpWindow.setScene(startUpScene);
		//Displays the content of the window stage
		startUpWindow.show();
		
		//Member log-in action event to sign in to the member account
		memberLoginButton.setOnAction(event-> 
		{
			if (event.getSource() == memberLoginButton)
			{
				ViewHandler.displayLogIn();
			}
		});
		
		//Member Sign-in action event to sign in new members
		memberSignInButton.setOnAction(event-> 
		{
			if(event.getSource() == memberSignInButton)
			{
				ViewHandler.displaySignUp();
			}
		
		});
		
		//Guest Order action event to order with member discount
		guestLoginButton.setOnAction(event-> 
		{
			if (event.getSource() == guestLoginButton)
			{
				//ViewHandler.startOrder("Enter Name");
				GuestLogin guestLogin = new GuestLogin();
				guestLogin.displayMenu();
			}
			
		});
		
		//Drink Menu action event to display the drink menu
		drinkMenuButton.setOnAction(event-> 
		{
			if (event.getSource() == drinkMenuButton)
			{
				ViewHandler.displayDrinkMenu();
				MenuWindow displayMenu = new MenuWindow();
				displayMenu.menuDisplayPage("General ");
			}
		});
		//Exit action event that closes the application window
		exitButton.setOnAction(event->
		{
			if(event.getSource() == exitButton)
			{
				startUpWindow.close();
				event.consume();
			}
		});
	}

	
	public static void main(String[] args)
	{
		launch(args);
	}		
}