package gui.component;

import javax.swing.JComponent;
import javax.swing.JLabel;

import ast.value.Undefined;
import ast.value.Value;

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
		this.label.setText(val.getValue().toString());
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
