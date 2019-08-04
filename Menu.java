package view;

import javax.swing.*;
import model.*;
import controller.*;

abstract public class Menu extends JFrame implements View, ModelListener 
{
	private Model model;
	private Controller controller;
	
	public Menu(Model model, Controller controller)
	{
		setModel(model);
		setController(controller);
	}
	
	public void registerWithModel()
	{
		((AbstractModel)model).addModelListener(this);
	}
	
	public Controller getController()
	{
		return controller;
	}
	
	public void setController(Controller controllerToSet)
	{
		this.controller = controllerToSet;
	}
	
	public Model getModel()
	{
		return model;
	}
	
	public void setModel(Model modelToSet)
	{
		this.model = modelToSet;
		registerWithModel();
	}
}