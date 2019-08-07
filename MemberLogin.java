package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.collections.ObservableList;
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
        Stage displayLogInWindow= new Stage();
        //Block events to other windows
        displayLogInWindow.initModality(Modality.APPLICATION_MODAL);
        displayLogInWindow.setTitle("Member Login");
        displayLogInWindow.setMinWidth(250);
        Label userNameLabel = new Label("Member Username :");
        Label passwordLabel = new Label("Password :");
        TextField userNameTextField = new TextField();
        TextField passWordTextField = new TextField();
        Label errorLabel = new Label("Invalid UserName or Password..Please Try Again");

        //Start Button
        Button logInButton = new Button("Member Login");
        logInButton.setOnAction(e ->
        {
            MemberLogin.userName = userNameTextField.getText();
            MemberLogin.password = passWordTextField.getText();

            //check whether userName and password are valid
            try 
            {
                //OutputStream output = new FileOutputStream("/resources/password.properties");
                InputStream input = new FileInputStream("/Users/vkonke/git/demo/resources/password.properties");
                Properties prop = new Properties();
                prop.load(input);
                int numberOftries = 3;

                if (prop.get(userName) != null && prop.get(password).equals(password)) 
                {
                    MenuWindow menuPage = new MenuWindow();
                    menuPage.menuDisplayWindow("Member");

                    CheckoutWindow checkoutPage = new CheckoutWindow();
                    checkoutPage.payment();
                }
                else
                	errorLabel.getContentDisplay();
            } 
            catch (IOException e1) 
            {
                e1.printStackTrace();
            }

            //if valid open a new page with menu

            // else throw invalid username or password

            System.out.print("closing window");
            displayLogInWindow.close();
        });
        
        //Exit Button
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> displayLogInWindow.close());
        
        //Styling nodes  
        logInButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        cancelButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
         
        userNameTextField.setStyle("-fx-font: normal bold 20px 'serif' "); 
        passWordTextField.setStyle("-fx-font: normal bold 20px 'serif' ");  
        
        //Display Set-up?
        VBox verticleBoxLayout = new VBox(10);
        verticleBoxLayout.setPadding(new Insets(20, 20, 20, 20));
        verticleBoxLayout.getChildren().addAll(userNameLabel, userNameTextField, passwordLabel, passWordTextField, logInButton, cancelButton);
        verticleBoxLayout.setAlignment(Pos.TOP_LEFT);
        verticleBoxLayout.setStyle("-fx-background-color: BEIGE;");
        //Display login window and wait for it to be cancelled before returning.
        Scene logInScene = new Scene(verticleBoxLayout);
        displayLogInWindow.setScene(logInScene);
        displayLogInWindow.showAndWait();
    }

    public static void displayDrinkMenu() 
    {
        Stage window = new Stage();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        //sets the window title to the parameter argument above
        window.setTitle("Drink Menu");
        //sets the minimum width of the drink menu window
        window.setMinWidth(250);

    }
}