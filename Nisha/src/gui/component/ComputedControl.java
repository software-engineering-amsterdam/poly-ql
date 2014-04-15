package gui.component;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ast.evaluate.Int;
import ast.evaluate.Value;

public class ComputedControl extends Control{

	private final JLabel label;
	private Value value;

	public ComputedControl() {
		super();
		label = new JLabel();
		label.setVisible(false);

	}

	public void setValue(Value val){
		//this.label.setText(val);
		this.value = val;
		if (val instanceof Int){
			this.label.setText(((Int)val).getValue().toString());
		}
		this.label.revalidate();
		this.label.repaint();
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