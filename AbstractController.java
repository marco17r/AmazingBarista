package controller;

import model.Model;
import view.View;

//The root of the Controller class hierarchy is the 
//AbstractController class. This class defines all the 
//basic facilities required to implement a controller.
//It allows a view and model to be linked to the controller.
//
//Provides a set of constructors along with
//accessor and mutator methods for both views and models.

public abstract class AbstractController implements Controller
{
	private View view;
	private Model model;
	
	public void setModel(Model targetModel)
	{
		this.model = targetModel;
	}
	
	public Model getModel()
	{
		return model;
	}
	
	public View getView()
	{
		return view;
	}
	
	public void setView(View targetView)
	{
		this.view = targetView;
	}
}
