package gui.component;

import javax.swing.JTextField;

public class TextField extends Control{
	
	private final static JTextField textfield= new JTextField(20);

	public TextField() {
		super(textfield);
	}

}
