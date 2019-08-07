package view;

public class GuestLogin 
{

    public void displayMenu() 
    {
        MenuWindow menuPage = new MenuWindow();
        menuPage.menuDisplayPage("Guest");

        CheckOutWindow checkoutPage = new CheckOutWindow();
        checkoutPage.payment();
    }
}