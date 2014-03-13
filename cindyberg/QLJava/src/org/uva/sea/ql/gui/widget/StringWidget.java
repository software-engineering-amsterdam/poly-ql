package org.uva.sea.ql.gui.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.StringValue;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.questionaire.State;

public class StringWidget extends Control{

	private JTextField textfield;
	
	public StringWidget(Identifier identifier, State state) {
		super(identifier, state);
		textfield = new JTextField();
		//TODO implement caretlistener
		textfield.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
					setValue(textToStringValue());
			}
		
		});
		setValue(new StringValue("empty"));
		
	}

	@Override
	public JComponent UIElement() {
		return textfield;
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		textfield.setEnabled(isEnabled);
	}

	public Value textToStringValue(){
		return new StringValue(textfield.getText());
	}
	@Override
	public void setValue(Value value) {
		textfield.setText(((StringValue) value).getValue());		
		setChanged();
		getState().putVariable(getIdentifier(), value);
		getState().notify(getIdentifier());	
	}

}
