package gui.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.value.Int;
import ast.value.Undefined;
import ast.value.Value;

public class IntTextField extends Widget implements KeyListener{
	
	private JTextField textField;

	public IntTextField() {
		super();
		textField = new JTextField(15);
		textField.addKeyListener(this);
	}
	
	@Override
	public JComponent getComponent() {
		return textField;
	}

	@Override
	public Value getValue() {
		if(!textField.getText().equals("")){
			return new Int(Integer.parseInt(textField.getText()));
		}
		return new Undefined();
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		publishEventChange();		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if(!Character.isDigit(c)){
			arg0.consume();
		}
	}

}
