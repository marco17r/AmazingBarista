package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//Class displays the main window
public class StartUpWindow extends Application
{
	Stage startUpWindow;
	
	//Initializes the application
	//@param stage
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		startUpWindow = primaryStage;
		startUpWindow.setTitle("Login Page");
		startUpWindow.setOnCloseRequest(event ->
		{
			event.consume();
		});

		Button memberSignInButton = new Button("Membership Sign-In");
		Button memberLoginButton = new Button("Membership Login");
		Button guestLoginButton = new Button("Guest Order");
		Button drinkMenuButton = new Button("Drink Menu");
		Button exitButton = new Button("Exit");
		
		
		HBox horizontalBox = new HBox();
		horizontalBox.getChildren().addAll(memberSignInButton, memberLoginButton, guestLoginButton, drinkMenuButton, exitButton);
		horizontalBox.setAlignment(Pos.BOTTOM_CENTER);

		BorderPane bp = new BorderPane();
		bp.setId("StartUpWindow");
		bp.setCenter(horizontalBox);
		
		Scene startUpScene =  new Scene(bp,700,373);
		startUpScene.getStylesheets().add("displayStyle.css");
		
		startUpWindow.setScene(startUpScene);
		startUpWindow.show();
		
		
		memberLoginButton.setOnAction(event->
		{
			if (event.getSource() == memberLoginButton)
			{
				MemberLogin.displayLogIn();
				startUpWindow.close();
			}
		});
		
		memberSignInButton.setOnAction(event->
		{
			if(event.getSource() == memberSignInButton)
			{
				ViewHandler.displaySignUp();
			}
		});
		
		guestLoginButton.setOnAction(event->
		{
			if(event.getSource() == guestLoginButton)
			{
				GuestLogin guestLogin = new GuestLogin();
				guestLogin.displayMenu();
			}
		});

		drinkMenuButton.setOnAction(event->
		{
			if (event.getSource() == drinkMenuButton)
			{
				ViewHandler.displayDrinkMenu();
				MenuWindow displayMenu = new MenuWindow();
				displayMenu.menuDisplayWindow("General ");
			}
		});
		
		exitButton.setOnAction(event->
		{
			if (event.getSource() == exitButton)
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