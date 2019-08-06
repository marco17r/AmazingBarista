package model;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class ModelEvent extends ActionEvent
{
	private BigDecimal amount;
	
	public ModelEvent(Object obj, int id, String message, BigDecimal amount)
	{
		super(obj, id, message);
		this.amount = amount;
	}
	
	public BigDecimal getAmount()
	{
		return amount;
	}
}