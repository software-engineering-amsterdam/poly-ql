package org.uva.sea.ql.gui.widget;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.StringValue;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.State;

public class StringWidget extends Control {

	private JTextField textfield;
	
	public StringWidget(Identifier identifier, State state){
		super(identifier,state);
		textfield = new JTextField();
	}
	
	@Override
	public JComponent UIElement() {
		return textfield;
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		textfield.setEnabled(isEnabled);
	}

	@Override
	public void setValue(Value value) {
		textfield.setText(((StringValue)value).getValue());
		
	}
}
