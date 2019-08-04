package view;
import javax.swing.*;
import model.Model;
import model.AbstractModel;
import model.ModelListener;
import controller.Controller;

//The JFrameView class is the root class of the view 
//hierarchy for top level (swing) frames. It allows a controller
//and a model to be registered and can register itself 
//with a model as an observer of that model.
//
//This is an extension of the JFrame class
//
//It requires the implementation of the modelChanged(ModelEvent event);
//method in order to work with the notification mechanisms in Java.

abstract public class JFrameView extends JFrame implements View, ModelListener 
{
	private Model model;
	private Controller controller;
	
	public JFrameView (Model model, Controller controller)
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
	
	public void setController(Controller controller)
	{
		this.controller = controller;
	}
	
	public Model getModel()
	{
		return model;
	}
	
	public void setModel(Model model)
	{
		this.model = model;
		registerWithModel();
	}
}