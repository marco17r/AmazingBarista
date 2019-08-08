package view;

public class GuestLogin 
{

    public void displayMenu() 
    {
    	boolean member = false;
        MenuWindow menuPage = new MenuWindow();
        menuPage.menuDisplayPage("Guest", member);

        CheckOutWindow checkoutPage = new CheckOutWindow();
        checkoutPage.payment();
    }
}