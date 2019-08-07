package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.PaymentMethodMap;

public class CheckOutWindow 
{

    public void payment()
    { 
        Stage paymentWindow = new Stage();
        //Block events to other windows
        paymentWindow.initModality(Modality.APPLICATION_MODAL);
        paymentWindow.setTitle("Member Login");
        paymentWindow.setMinWidth(800);
        paymentWindow.setMaxWidth(1000);

        VBox verticleBoxLayout = new VBox(10);
        verticleBoxLayout.setPadding(new Insets(20, 20, 20, 20));
        Label firstNameLabel = new Label("FirstName:");
        Label lastNameLabel = new Label("LastName:");
        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();
        Button submitButton = new Button("Submit Payment");
        Label thankYouLabel = new Label("Thank You For Ordering with Amazing Barista!");

        PaymentMethodMap paymentMethodMap = new PaymentMethodMap();
        final ComboBox paymentOptionBox = new ComboBox();

        paymentOptionBox.getItems().addAll(paymentMethodMap.getPaymentMethod(0), paymentMethodMap.getPaymentMethod(1), paymentMethodMap.getPaymentMethod(2), paymentMethodMap.getPaymentMethod(3), paymentMethodMap.getPaymentMethod(4), paymentMethodMap.getPaymentMethod(5), paymentMethodMap.getPaymentMethod(6));

        paymentOptionBox.setOnAction(event -> 
        {
            performActionOnSelectedComboBox((String) paymentOptionBox.getSelectionModel().getSelectedItem());
        });

        submitButton.setOnAction(event ->
        {
                thankYouLabel.setText("Thank you for your payment...Enjoy your drink");
            try 
            {
                Thread.sleep(10L);
            } 
            catch (InterruptedException otherEvent) 
            {
                otherEvent.printStackTrace();
            }
            paymentWindow.close();
        });

        verticleBoxLayout.getChildren().addAll(firstNameLabel, firstNameTextField, lastNameLabel, lastNameTextField, paymentOptionBox,submitButton,thankYouLabel);
        Scene paymentScene = new Scene(verticleBoxLayout);
        paymentWindow.setScene(paymentScene);
        //Display Payment window and wait for it to be cancelled before returning.
        paymentWindow.showAndWait();
    }

    private void performActionOnSelectedComboBox(String selectedCase) 
    {
        switch(selectedCase)
        {
		    case "Visa Card":
		    case "Master Card":
		    case "Discovery Card":
		    case "AMEX":
            Stage comboBoxWindow = new Stage();
            //Block events to other windows
            comboBoxWindow.initModality(Modality.APPLICATION_MODAL);
            comboBoxWindow.setTitle("Member Login");
            comboBoxWindow.setMinWidth(800);
            comboBoxWindow.setMaxWidth(1000);

            VBox verticleBoxOuterLayout = new VBox();
            Label cardNumberLabel = new Label("Card Number :");
            TextField cardText = new TextField();
            Label cardExpiry = new Label("Valid thru :");
            Label cc = new Label("cc :");
            TextField ccNumber = new TextField();
            DatePicker checkInDatePicker = new DatePicker();
            HBox horizontalBoxInnerLayout = new HBox();
            horizontalBoxInnerLayout.getChildren().addAll(cardExpiry, checkInDatePicker, cc, ccNumber);
            horizontalBoxInnerLayout.setSpacing(50);
            Button submitCardPaymentButton = new Button("Submit Card Payment");
            submitCardPaymentButton.setOnAction(event-> comboBoxWindow.close());
            horizontalBoxInnerLayout.getChildren().add(submitCardPaymentButton);
            verticleBoxOuterLayout.getChildren().addAll(cardNumberLabel, cardText, horizontalBoxInnerLayout);

            Scene comboBoxScene = new Scene(verticleBoxOuterLayout);
            comboBoxWindow.setScene(comboBoxScene);
            comboBoxWindow.showAndWait();
        }
    }
}

//new PaymentMethod(0,"No payment method used", 0),
//    new PaymentMethod(1,"Cash payment method used", 0),
//    new PaymentMethod(2,"Paper Check payment method used", 0),
//    new PaymentMethod(3,"Visa payment method used", 0),
//    new PaymentMethod(4,"MasterCard payment method used", 0),
//    new PaymentMethod(5,"Discovery payment method used", 0),
//    new PaymentMethod(6,"AMEX payment method used", 0),