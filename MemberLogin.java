package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MemberLogin 
{

    public static String userName;
    public static String password;

    public static ObservableList<Object> Menu;

    public static void displayLogIn() 
    {
        Stage displayLogInWindow = new Stage();
        //Block events to other windows
        displayLogInWindow.initModality(Modality.APPLICATION_MODAL);
        displayLogInWindow.setTitle("Member Login");
        displayLogInWindow.setMinWidth(250);
        Label userNameLabel = new Label("UserName :");
        Label passwordLabel = new Label("Password :");
        TextField userNameTextField = new TextField();
        PasswordField userPassWordTextField = new PasswordField();
        Label errorLabel = new Label("Invalid User Name and/or Password..Please Try Again");

        //Starts the login process button Button
        Button logInButton = new Button("Member Login");
        logInButton.setOnAction(event ->
        {
            MemberLogin.userName = userNameTextField.getText();
            MemberLogin.password = userPassWordTextField.getText();

            //check whether userName and password are valid
            try 
            {
                //OutputStream output = new FileOutputStream("/resources/password.properties");
                InputStream fileInput = new FileInputStream("password.properties");
                Properties fileInputProperties = new Properties();
                fileInputProperties.load(fileInput);
                int maxNumberOfTries = 3;
                int iterator = 0;
                
                for(iterator = 0; iterator < maxNumberOfTries; iterator++)
                {
                	//if valid open a new page with menu
                	if (fileInputProperties.get(userName) != null && fileInputProperties.get(password).equals(password)) 
                    {
                        MenuWindow menuPage = new MenuWindow();
                        menuPage.menuDisplayPage("Member");

                        CheckOutWindow checkoutPage = new CheckOutWindow();
                        checkoutPage.payment();
                    }
                }
                if(iterator == 3)
                	// else throw invalid user name or password
                	errorLabel.getContentDisplay();
            } 
            catch (IOException otherEvent) 
            {
                otherEvent.printStackTrace();
            }
            
            System.out.print("closing window");
            displayLogInWindow.close();
        });
        
        //Cancel Button
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> displayLogInWindow.close());
        
        //Styling nodes  
	    logInButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 	
	    cancelButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	    userNameTextField.setStyle("-fx-font: normal bold 20px 'serif' "); 
	    userPassWordTextField.setStyle("-fx-font: normal bold 20px 'serif' ");  
        
        //Verticle Box Layout Set-up
        VBox verticleBoxLayout = new VBox(10);
        verticleBoxLayout.setPadding(new Insets(20, 20, 20, 20));
        verticleBoxLayout.getChildren().addAll(userNameLabel, userNameTextField, passwordLabel, userPassWordTextField, logInButton, cancelButton);
        verticleBoxLayout.setAlignment(Pos.TOP_LEFT);
        verticleBoxLayout.setStyle("-fx-background-color: BEIGE;");
        //Display login window and wait for it to be cancelled before returning.
        Scene logInScene = new Scene(verticleBoxLayout);
        displayLogInWindow.setScene(logInScene);
        displayLogInWindow.showAndWait();
    }

    public static void displayDrinkMenu() 
    {
        Stage displayDrinkMenuWindow = new Stage();
        //Block events to other windows
        displayDrinkMenuWindow.initModality(Modality.APPLICATION_MODAL);
        //sets the window title to the parameter argument above
        displayDrinkMenuWindow.setTitle("Drink Menu");
        //sets the minimum width of the drink menu window
        displayDrinkMenuWindow.setMinWidth(250);

    }
}