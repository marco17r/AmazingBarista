package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

//Abstract root class of Model hierarchy - provides basic
//notification behaviour

public abstract class AbstractModel implements Model
{
	private ArrayList listeners = new ArrayList(5);
	
	//Method that is called by subclasses of AbstractModel
	//when they want to notify other classes of changes 
	//to themselves.
	
	public void notifyChanged(ModelEvent event)
	{
		ArrayList list = (ArrayList)listeners.clone();
		Iterator it = list.iterator();
		while(it.hasNext()) 
		{
			ModelListener ml = (ModelListener)it.next();
				ml.modelChanged(event);
		}
	}
	
	//Add a ModelListener to the list of objects 
	//interested in ModelEvents.
	public void addModelListener(ModelListener listenerToAdd)
	{
		listeners.add(listenerToAdd);
	}
	
	//Remove a ModelListener from the list of objects 
	//interested in ModelEvents.
	public void removeModeListener(ModelListener listenerToRemove)
	{
		listeners.remove(listenerToRemove);
	}
}
