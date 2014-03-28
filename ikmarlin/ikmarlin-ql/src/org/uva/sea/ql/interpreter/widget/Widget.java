package org.uva.sea.ql.interpreter.widget;

import java.util.EventListener;

import javax.swing.JComponent;

import org.uva.sea.ql.interpreter.value.Value;

public abstract class Widget {
	
	public abstract void setValue(Value<?> value);
	
	public abstract Value<?> getValue();
	
	public abstract JComponent getWidget();
	
	public abstract void setWidget(JComponent widget);
	
	public abstract void setActionListener(EventListener listener);

}
