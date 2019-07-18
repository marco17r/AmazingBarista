package controller;
import model.Model;
import view.View;

public interface Controller 
{
	void setOrder(Order order);
	Order getOrder();
	View getView();
	void setView(View view);
}
