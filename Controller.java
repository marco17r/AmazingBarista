package controller;

import model.Model;
import view.View;

//The Controller interface is the interface which must be
//implemented by all classes which wish to take the role
//of a Controller. All controllers must be able to reference
//a model and a view object.
//
//The primary role of a Controller within the MVC is to 
//determine what should happen in response to user input.

public interface Controller 
{
	void setModel(Model modelToSet);
	Model getModel();
	void setView(View viewToSet);
	View getView();
}
