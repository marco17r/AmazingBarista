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

public class CheckoutPage {

    public void payment(){
        Stage window = new Stage();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Member Login");
        window.setMinWidth(800);
        window.setMaxWidth(1000);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        Label firstNameLabel = new Label("FirstName:");
        Label lastNameLabel = new Label("LastName:");
        TextField firstNameText = new TextField();
        TextField lastNameText = new TextField();
        Button submitButton = new Button("Submit Payment");
        TextField thankYouText = new TextField();

        PaymentMethodMap paymentMethodMap = new PaymentMethodMap();
        final ComboBox paymentOptions = new ComboBox();

        paymentOptions.getItems().addAll(
            paymentMethodMap.getPaymentMethod(0),
            paymentMethodMap.getPaymentMethod(1),
            paymentMethodMap.getPaymentMethod(2),
            paymentMethodMap.getPaymentMethod(3),
            paymentMethodMap.getPaymentMethod(4),
            paymentMethodMap.getPaymentMethod(5),
            paymentMethodMap.getPaymentMethod(6)
        );


        paymentOptions.setOnAction(e -> {
            performActionOnSelectedComboBox((String) paymentOptions.getSelectionModel().getSelectedItem());
        });

        submitButton.setOnAction(e ->{
                thankYouText.setText("Thank you for your payment...Enjoy your drink");
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            window.close();
        });

        layout.getChildren().addAll(firstNameLabel, firstNameText, lastNameLabel, lastNameText, paymentOptions,submitButton,thankYouText);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    private void performActionOnSelectedComboBox(String selectedItem) {
        switch(selectedItem){
        case "Visa Card":
        case "Master Card":
        case "Discovery Card":
        case "AMEX":
            //Block events to other windows
            Stage window = new Stage();
            //Block events to other windows
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Member Login");
            window.setMinWidth(800);
            window.setMaxWidth(1000);

            VBox layout = new VBox();
            Label cardLabel = new Label("Card Number");
            TextField cardText = new TextField();
            Label cardExpiry = new Label("Card Expiry");
            Label cc = new Label("cc");
            TextField ccNumber = new TextField();
            DatePicker checkInDatePicker = new DatePicker();
            HBox hBox = new HBox();
            hBox.getChildren().add(cardExpiry);
            hBox.setSpacing(10);
            hBox.getChildren().add(checkInDatePicker);
            hBox.setSpacing(50);
            hBox.getChildren().add(cc);
            hBox.setSpacing(10);
            hBox.getChildren().add(ccNumber);
            hBox.setSpacing(50);
            Button submitCardPayment = new Button("Submit Card Payment");
            submitCardPayment.setOnAction(e-> window.close());
            hBox.getChildren().add(submitCardPayment);
            layout.getChildren().addAll(cardLabel, cardText, hBox);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();
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
