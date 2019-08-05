package view;

public class GuestLogin 
{

    public void displayMenu() 
    {
        MenuWindow menuPage = new MenuWindow();
        menuPage.menuDisplayPage("Guest");

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.payment();
    }
}
