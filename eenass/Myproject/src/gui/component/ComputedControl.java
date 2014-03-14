package gui.component;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ast.expr.evaluate.Value;

public class ComputedControl extends Control{

	private final JLabel label;
	private Value value;
	
	public ComputedControl() {
		super();
		label = new JLabel();
		value = null;
	}

	public void setValue(Value val){
		value = val;
		this.label.setText(value.toString());
	}
	@Override
	public JComponent getComponent() {
		return label;
	}

	@Override
	public Value getValue() {
		return value;
	}

}
