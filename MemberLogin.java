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

public class MemberLogin {

    public static String userName;

    public static String password;

    public static ObservableList<Object> Menu;

    public static void displayLogIn() {
        Stage window = new Stage();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Member Login");
        window.setMinWidth(250);
        Label userNameLabel = new Label("UserName:");
        Label passwordLabel = new Label("Password:");
        TextField userNameInput = new TextField();
        TextField passwordInput = new TextField();
        TextField errorText = new TextField();

        //Start Button
        Button logInButton = new Button("Member Login");
        logInButton.setOnAction(e ->
        {
            MemberLogin.userName = userNameInput.getText();
            MemberLogin.password = passwordInput.getText();

            //check whether userName and password are valid
            try {
                //                OutputStream output = new FileOutputStream("/resources/password.properties");
                InputStream input = new FileInputStream("/Users/vkonke/git/demo/resources/password.properties");
                Properties prop = new Properties();
                prop.load(input);
                int numberOftries = 3;

                if (prop.get(userName) != null && prop.get(userName).equals(password)) {
                    MenuPage menuPage = new MenuPage();
                    menuPage.menuDisplayPage("Member");

                    CheckoutPage checkoutPage = new CheckoutPage();
                    checkoutPage.payment();
                }

                errorText.setText("Invalid UserName or Password..Please Try Again");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            //if valid open a new page with menu

            // else throw invalid username or password

            System.out.print("closing window");
            window.close();
        });
        //Exit Button
        Button cancelButton = new Button("CANCEL");
        cancelButton.setOnAction(e -> window.close());
        //Display Set-up?
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(userNameLabel, userNameInput, passwordLabel, passwordInput, logInButton, cancelButton, errorText);
        layout.setAlignment(Pos.TOP_LEFT);
        //Display login window and wait for it to be cancelled before returning.
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void displayDrinkMenu() {
        Stage window = new Stage();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        //sets the window title to the parameter argument above
        window.setTitle("Drink Menu");
        //sets the minimum width of the drink menu window
        window.setMinWidth(250);

    }
}