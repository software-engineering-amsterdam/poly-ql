package gui.component;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ast.value.Bool;
import ast.value.Value;

public class CheckBox extends Widget implements ItemListener{

	private JCheckBox checkBox;
	
	public CheckBox() {
		super();
		checkBox = new JCheckBox();
		checkBox.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		publishEventChange();		
	}

	@Override
	public JComponent getComponent() {
		return checkBox;
	}

	@Override
	public Value getValue() {
		return new Bool(checkBox.isSelected());
	}

}
