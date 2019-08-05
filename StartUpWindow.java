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
	Stage window;
	
	//Initializes the application
	//@param stage
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("Login Page");
		window.setOnCloseRequest(e ->
		{
			e.consume();
		});

		/*-------------------------------------------------- */
		Button memberLoginButton = new Button("Membership Login");
		Button guestLoginButton = new Button("Continue as Guess");
		Button exitButton = new Button("Exit");
		
		/*-------------------------------------------------- */
		HBox hbox = new HBox();
		hbox.getChildren().addAll(memberLoginButton, guestLoginButton, exitButton);
		hbox.setSpacing(5.0);
		hbox.setAlignment(Pos.CENTER);
		/*-------------------------------------------------- */
		BorderPane bp = new BorderPane();
		bp.setId("StartUpWindow");
		bp.setCenter(hbox);
		
		/*-------------------------------------------------- */
		Scene scene1 =  new Scene(bp, 900,373);//373
		scene1.getStylesheets().add("style.css");
		
		
		/*-------------------------------------------------- */
		window.setScene(scene1);
		window.show();
		
		/*-------------------------------------------------- */
		
		memberLoginButton.setOnAction(e->
		{
			if (e.getSource() == memberLoginButton)
			{
				MemberLogin.displayLogIn();
				window.close();
			}
		});
		/*-------------------------------------------------- */
		guestLoginButton.setOnAction(e->
		{
			if(e.getSource() == guestLoginButton)
			{
				GuestLogin guestLogin = new GuestLogin();
				guestLogin.displayMenu();
			}
		
		});
		/*-------------------------------------------------- */
//		button3.setOnAction(e->
//		{
//			if (e.getSource() == button3)
//			{
//				ViewHandler.displayDrinkMenu();
//			}
//
//		});
		
		/*-------------------------------------------------- */
		exitButton.setOnAction(e->
		{
			if (e.getSource() == exitButton)
			{
				window.close();
				e.consume();
			}
		});
		/*-------------------------------------------------- */
		
	}

	
	public static void main(String[] args)
	{
		launch(args);
	}		
}