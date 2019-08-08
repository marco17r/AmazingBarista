package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color; 
import javafx.scene.paint.CycleMethod; 
import javafx.scene.paint.LinearGradient; 
import javafx.scene.paint.Stop; 
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.awt.Paint;
import java.awt.color.*;
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 

//Class displays the main window
public class StartUpWindow extends Application
{
	Stage startUpWindow;
	
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
		
		// Declare Text object for function image in the start up screen.
		Text welcomeText = new Text("Amazing Barista!");

		//Declare Text object for small credit line below the welcomeText
		Text setUpText = new Text("By : RR Group 6 :");
		Text creditText = new Text("Aravind Rajadurai");
		Text creditText1 = new Text("Marco Romano");

		//Setting the font of the text object
		welcomeText.setFont(Font.font("Edwardian Script ITC", 111));
		setUpText.setFont(Font.font("Times New Roman", 40));
		creditText.setFont(Font.font("Times New Roman", 40));
		creditText1.setFont(Font.font("Times New Roman", 40));
		
		//Setting the linear gradient
		Stop[] stops = new Stop[]
		{
			new Stop(0, Color.DARKGOLDENROD),
			new Stop(1, Color.INDIANRED)
		};
		LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		
		//Setting the linear gradient to the text object
		welcomeText.setFill(linearGradient);
		setUpText.setFill(linearGradient);
		creditText.setFill(linearGradient);
		creditText1.setFill(linearGradient);

		//Declare an horizontal box to put buttons in
		HBox horizontalButtonBox = new HBox();
		// Declare a vertical box to put text objects in
		VBox verticalTextBoxLayout = new VBox();
		verticalTextBoxLayout.getChildren().addAll(setUpText, creditText, creditText1);
		verticalTextBoxLayout.setAlignment(Pos.BASELINE_CENTER);
		//Retrieving the observable list of buttons getting added to the HBox
		ObservableList list = horizontalButtonBox.getChildren();
		//Adding all the nodes to the observable list
		list.addAll(memberSignInButton, memberLoginButton, guestLoginButton, drinkMenuButton, exitButton);
		//Aligns the button box to the bottom center of the screen
		horizontalButtonBox.setAlignment(Pos.BOTTOM_CENTER);
		
		BorderPane bPane = new BorderPane();
		bPane.setId("StartUpWindow");
		bPane.setTop(welcomeText);
		bPane.setCenter(verticalTextBoxLayout);
		bPane.setBottom(horizontalButtonBox);
		
		//Styling Button Objects
		memberSignInButton.setStyle("-fx-background-color: orangered; -fx-text-fill: white;"); 
		memberLoginButton.setStyle("-fx-background-color: navy; -fx-text-fill: white;"); 
		guestLoginButton.setStyle("-fx-background-color: magenta; -fx-text-fill: white;"); 
		drinkMenuButton.setStyle("-fx-background-color: red; -fx-text-fill: white;"); 
		exitButton.setStyle("-fx-background-color: indigo; -fx-text-fill: white;"); 
		  
	    horizontalButtonBox.setStyle("-fx-background-color: aqua;"); 
		
	    //Creating a scene object
		Scene startUpScene =  new Scene(bPane, 700, 353);
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
				MemberLogin.displayLogIn();
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
				boolean member = true;
				//ViewHandler.displayDrinkMenu();
				MenuWindow displayMenu = new MenuWindow();
				displayMenu.menuDisplayPage("General ", member);
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