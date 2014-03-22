package org.uva.sea.ql.gui.widget;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.IntegerValue;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.questionaire.State;

public class IntegerWidget extends Widget{

	private final JTextField textfield;
	
	public IntegerWidget(Identifier identifier, State state) {
		super(identifier, state);
		textfield = new JTextField();
		textfield.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e){
				if(isInteger()){
					setValue(textToIntValue());
				}
			}
		});		
		setValue(new IntegerValue(0));
	}
	
	private boolean isInteger() {
		try{
			Integer.parseInt(textfield.getText());	
		}
		catch(NumberFormatException e){
			textfield.setBackground(Color.red);
			return false;
		}
		textfield.setBackground(Color.white);
		return true;
	}

	@Override
	public JComponent UIElement() {
		return textfield;
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		textfield.setEnabled(isEnabled);
	}

	public Value textToIntValue(){
		return new IntegerValue(Integer.parseInt(textfield.getText()));
	}
	
	@Override
	public void setValue(Value value) {
		textfield.setText(((IntegerValue) value).getValue().toString());		
		setChanged();
		getState().addIdentifier(getIdentifier(), value);
		getState().notify(getIdentifier());
		
	}
	

}
