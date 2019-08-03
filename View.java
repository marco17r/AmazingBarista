package view;

import model.*;
import controller.*;

//This interface must be implemented by all classes that 
//wish to take the role of the View within the MVC framework.
//The role of a View is the display of information and the 
//capture of data entered.

public interface View 
{
	Controller getController();
	void setController(Controller controller);
	Model getModel();
	void setModel(Model model);
}
