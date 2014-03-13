package org.uva.sea.ql.gui.widget;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.IntegerValue;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.State;

public class IntegerWidget extends Control{

	private JTextField textfield;
	
	public IntegerWidget(Identifier identifier, State state) {
		super(identifier, state);
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
		Integer intvalue = ((IntegerValue)value).getValue();
		textfield.setText(intvalue.toString());
		
	}
	

}
