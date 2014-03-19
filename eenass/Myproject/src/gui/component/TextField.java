package gui.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.expr.evaluate.Int;
import ast.expr.evaluate.Value;

public class TextField extends Control implements KeyListener{
	
	private JTextField textField;

	public TextField() {
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
		return new Int(0);
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
		
	}

}
