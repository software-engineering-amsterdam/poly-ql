package gui.component;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Int;
import ast.expr.evaluate.Value;

public class ComputedControl extends Control{

	private final JLabel label;
	private Value value;
	
	public ComputedControl() {
		super();
		label = new JLabel();
		label.setVisible(false);
		value = null;
	}

	public void setValue(Value val){
		value = val;
		if (val instanceof Int){
			this.label.setText(((Int)value).getValue().toString());
		}
//		else if(val instanceof Bool){
//			this.label.setText(((Bool)value).getValue());
//		}	
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
