package gui.component;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import expr.Ident;

import ast.evaluate.Int;
import ast.evaluate.Undefined;
import ast.evaluate.Value;

public class TextField extends Control implements KeyListener{

	private JPanel textPanel;
	private JTextField textField;
	public TextField(String text, Ident id) {
		super();
		textPanel = new JPanel();
		textField = new JTextField(15);
		JLabel label=new JLabel(text);
		label.setLabelFor(textField);
		//System.out.println(label);
		textPanel.add(label);
		textPanel.add(textField, BorderLayout.CENTER);
		textField.addKeyListener(this);
	}

	@Override
	public JComponent getComponent() {
		return textPanel;
	}

	@Override
	public Value getValue() {
		if(!textField.getText().equals("")){
			//System.out.println("getvalue of textfield " + textField.getText());
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

	}

}