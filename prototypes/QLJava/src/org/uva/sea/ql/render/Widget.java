package org.uva.sea.ql.render;

import javax.swing.JComponent;

import org.uva.sea.ql.eval.Value;

public abstract class Widget {
	private final JComponent component;
	
	public Widget(JComponent component) {
		this.component = component;
	}
	
	public JComponent getComponent() {
		return component;
	}

	public abstract void setValue(Value value);
	public abstract Value getValue();
	public abstract void setHandler(Handler handler);
	
}

