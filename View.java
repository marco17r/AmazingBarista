package view;
import model.Model;
import controller.Controller;

public interface View
{
	Controller getController();
	Void setController(Controller controller);
	Model getModel();
	Void setModel (Model model);
}