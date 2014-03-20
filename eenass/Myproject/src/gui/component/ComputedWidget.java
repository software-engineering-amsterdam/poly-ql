package gui.component;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ast.expr.value.Int;
import ast.expr.value.Undefined;
import ast.expr.value.Value;

public class ComputedWidget extends Widget{

	private final JLabel label;
	private Value value;
	
	public ComputedWidget() {
		super();
		label = new JLabel();
		label.setVisible(false);
		value = new Undefined();
	}

	public void setValue(Value val){
		this.value = val;
		if (val instanceof Int){
			this.label.setText(((Int)val).getValue().toString());
		}
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
