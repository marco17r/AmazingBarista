package view;

import javafx.application.Application;
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
	Stage window;
	
	//Initializes the application
	//@param stage
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setOnCloseRequest(e ->
		{
			e.consume();
		});
		
		/*-------------------------------------------------- */
		Button button1 = new Button("Membership Login");
		Button button2 = new Button("Membership Sign-Up");
		Button button3 = new Button("Guest Order");
		Button button4 = new Button("Drink Menu");
		Button button5 = new Button("Exit");
		
		/*-------------------------------------------------- */
		HBox hbox = new HBox();
		hbox.getChildren().addAll(button1, button2, button3, button4, button5);	
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		/*-------------------------------------------------- */
		BorderPane bp = new BorderPane();
		bp.setId("StartUpWindow");
		bp.setCenter(hbox);
		
		/*-------------------------------------------------- */
		Scene scene1 =  new Scene(bp, 700, 353);//373
		scene1.getStylesheets().add("displayStyle.css");
		
		/*-------------------------------------------------- */
		window.setScene(scene1);
		window.show();
		
		/*-------------------------------------------------- */
		
		button1.setOnAction(e-> 
		{
			if (e.getSource() == button1)
			{
				ViewHandler.displayLogIn();
			}
		});
		/*-------------------------------------------------- */
		button2.setOnAction(e-> 
		{
			if(e.getSource() == button2)
			{
				ViewHandler.displaySignUp();
			}
		
		});
		/*-------------------------------------------------- */
		button3.setOnAction(e-> 
		{
			if (e.getSource() == button3)
			{
				//ViewHandler.startOrder("Enter Name");
			}
			
		});
		
		/*-------------------------------------------------- */
		button4.setOnAction(e-> 
		{
			if (e.getSource() == button4)
			{
				ViewHandler.displayDrinkMenu();
			}
		});
		/*-------------------------------------------------- */
		button5.setOnAction(e->
		{
			if(e.getSource() == button5)
			{
				window.close();
				e.consume();
			}
		});
	}

	
	public static void main(String[] args)
	{
		launch(args);
	}		
}