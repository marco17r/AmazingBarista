package view;

public class GuestLogin {

    public void displayMenu() {
        MenuPage menuPage = new MenuPage();
        menuPage.menuDisplayPage("Guest");

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.payment();
    }
}
