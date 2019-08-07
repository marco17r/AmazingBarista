package view;

public class GuestLogin 
{

    public void displayMenu() 
    {
        MenuWindow menuPage = new MenuWindow();
        menuPage.menuDisplayWindow("Guest");

        CheckoutWindow checkoutPage = new CheckoutWindow();
        checkoutPage.payment();
    }
}
