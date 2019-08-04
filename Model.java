package model;

//This interface must be implemented by all classes that 
//wish to play the Model role within the MVC framework.
//
//The only method specified by the interface is the:
//notifyChanged() method.
public interface Model 
{
	void notifyChanged(ModelEvent event);
}
