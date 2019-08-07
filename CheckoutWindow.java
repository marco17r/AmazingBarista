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


/**
 * 
 * @author m_r382
 *
 */
public class CheckoutWindow 
{
	/**
	 * Payment method displays payment window for order transaction.
	 */

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
        final ComboBox paymentOptionsBox = new ComboBox();

        paymentOptionsBox.getItems().addAll(
            paymentMethodMap.getPaymentMethod(0),
            paymentMethodMap.getPaymentMethod(1),
            paymentMethodMap.getPaymentMethod(2),
            paymentMethodMap.getPaymentMethod(3),
            paymentMethodMap.getPaymentMethod(4),
            paymentMethodMap.getPaymentMethod(5),
            paymentMethodMap.getPaymentMethod(6)
        );


        paymentOptionsBox.setOnAction(e -> 
        {
            performActionOnSelectedComboBox((String) paymentOptionsBox.getSelectionModel().getSelectedItem());
        });

        submitButton.setOnAction(e ->
        {
                thankYouLabel.setText("Thank you for your payment...Enjoy your drink");
            try 
            {
                Thread.sleep(10L);
            } 
            catch (InterruptedException e1) 
            {
                e1.printStackTrace();
            }
            paymentWindow.close();
        });

        verticleBoxLayout.getChildren().addAll(firstNameLabel, firstNameTextField, lastNameLabel, lastNameTextField, paymentOptionsBox,submitButton,thankYouLabel);
        Scene paymentScene = new Scene(verticleBoxLayout);
        paymentWindow.setScene(paymentScene);
        paymentWindow.showAndWait();
    }

    private void performActionOnSelectedComboBox(String selectedItem) 
    {
        switch(selectedItem)
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

            VBox verticleBoxLayout = new VBox();
            Label cardNumberLabel = new Label("Card Number");
            TextField cardNumberTextField = new TextField();
            Label cardExpiry = new Label("Valid Thru :");
            Label cc = new Label("cc");
            TextField ccNumber = new TextField();
            DatePicker checkInDatePicker = new DatePicker();
            HBox horizontalBox = new HBox();
            horizontalBox.getChildren().add(cardExpiry);
            horizontalBox.setSpacing(10);
            horizontalBox.getChildren().add(checkInDatePicker);
            horizontalBox.setSpacing(50);
            horizontalBox.getChildren().add(cc);
            horizontalBox.setSpacing(10);
            horizontalBox.getChildren().add(ccNumber);
            horizontalBox.setSpacing(50);
            Button submitCardPaymentButton = new Button("Submit Card Payment");
            submitCardPaymentButton.setOnAction(e-> comboBoxWindow.close());
            
            horizontalBox.getChildren().add(submitCardPaymentButton);
            verticleBoxLayout.getChildren().addAll(cardNumberLabel, cardNumberTextField, horizontalBox);

            Scene comboBoxScene = new Scene(verticleBoxLayout);
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
