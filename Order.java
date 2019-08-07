package model;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Order extends AbstractModel
{
	private BigDecimal subtotal;
	public static BigDecimal runningTotal;
	private static double itemPrice;
	private static int itemQuality;
	static boolean ordering = true;
	static Scanner input = new Scanner(System.in);
	private int arraySize;
	private int orderSize;
	private Drink[] order;
	
	//Default Constructor without arguments
	//Empty array of 5 elements
	public Order()
	{
		new BigDecimal("0.0");
		subtotal = new BigDecimal("0.0");
		arraySize = 5;
		orderSize = 0;
		order = new Drink[arraySize];
		System.out.println("New Order started!");
	}
	
	//Constructor with arguments
	public Order(BigDecimal OrderSTotal, int orderArraySize, int orderOSize, Drink[] orderArray)
	{
		subtotal = OrderSTotal;
		arraySize = orderArraySize;
		orderSize = orderOSize;
		orderArray = new Drink[arraySize];
		System.out.println("New Order started!");
	}
	//Method to add drinks to order
	public void addToOrder(Drink orderItem, BigDecimal drinkQuality)
	{
		order[orderSize] = orderItem;
		subtotal = subtotal.add(order[orderSize].getPrice().multiply(drinkQuality));
		System.out.println("added the following drink to the order: " + order[orderSize].getName());
		ModelEvent me = new ModelEvent(orderItem,0,"order item added",0);
		orderSize++;
		notifyChanged(me);
	}
	//Method to remove a drink by it's position index in the order drinks array.
	public void removeFromOrder(int removeIndex)
	{
		//remove the Item price from the subtotal
		subtotal = subtotal.subtract(order[removeIndex].getPrice());
		//filled in the gap in the array from the removal
		for(int i = removeIndex; i < orderSize; i++)
		{
			order[i] = order[i+1];
		}
		order[orderSize] = null;
		System.out.println("Removing from order confirmed!");
		ModelEvent me = new ModelEvent(this,0,"order removed",0);
		orderSize--;
		notifyChanged(me);
	}
	//Method to start a new order
	public void clearOrder()
	{
		subtotal = new BigDecimal("0.0");
		orderSize = 0;
		System.out.println("Starting a new order");
		ModelEvent me = new ModelEvent(this,0,"New Order",0);
		notifyChanged(me);
	}
	//Accessor Method to get an order total.
	public BigDecimal getOrderTotal()
	{
		System.out.println("Order Total is: " + subtotal);
		return subtotal;
	}
	//Accessor Method to get an order array's size
	public int getOrderSize()
	{
		System.out.println("Retrieving Order Size: " + orderSize);
		return orderSize;
	}
	//Accessor Method to get an order item.
	public Drink getOrderItem(int orderItemIndex)
	{
		System.out.println("Retrieving Order Item: " + order[orderItemIndex]);
		return order[orderItemIndex];
	}
	
	public static double quantity()
	{
		System.out.println("Enter quantity");
		int quantity = input.nextInt();
		itemQuality = quantity;
		System.out.println("Enter Membership Type :");
		int memberType = input.nextInt();
		double discount = 0;
		if (memberType == 0)
			discount = .05;
		else if (memberType == 1)
			discount = .17;
		else if (memberType == 2)
			discount = .20;
		double newDrinkPrice = calculatePriceAfterBenefits(discount, itemPrice);
		calculateSubTotal(quantity, newDrinkPrice);
		return quantity;
	}
	
	public static double calculateSubTotal(double quantity, double itemPrice)
	{
		//int userDiscountPercentage = userDiscountType. 
		double currentSubTotal = quantity * itemPrice;
		System.out.println("Subtotal: $" + currentSubTotal);
		return currentSubTotal;
	}
	
	public static double calculatePriceAfterBenefits(double benefitDiscountPercentage, double itemPrice)
	{
		double newPrice = itemPrice * (itemPrice * benefitDiscountPercentage);
		System.out.println("Member Price: $" + newPrice);
		return newPrice;
	}
	
	public static void done(double runningTotal)
	{
		ordering = false;
		System.out.println("Enjoy your drinks");
	}
}
