package org.uva.sea.ql.gui;

import javax.swing.JComponent;

public class InputField {
	private final JComponent component;
	
	public InputField(JComponent component) {
		this.component = component;
	}

	public JComponent getComponent() {
		return component;
	}
}
