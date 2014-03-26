package org.uva.sea.ql.gui.inputs;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.eval.Bool;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.eval.ValueEnvironment;

public class BoolInput extends Input {
	private final JCheckBox component;

	public BoolInput(final Question question, final ValueEnvironment valueEnv, boolean isComputed) {
		super(question, valueEnv, isComputed);
		this.component = new JCheckBox();
		this.component.setEnabled(!isComputed);
		this.component.addItemListener(new ItemListener() {
			@Override
		    public void itemStateChanged(ItemEvent e) {
				System.out.println("State changed in " + question.getName());
				valueEnv.setValueOfIdent(question.getName(), getValue());
		        setChanged();
		        notifyObservers(valueEnv);
		    }
		});
	}
	
	@Override
	public Value getValue() {
		return new Bool(this.component.isSelected());
	}

	@Override
	public void setValue(Value value) {
		this.component.setSelected(((Bool)value).getValue());
	}
	
	@Override
	public JComponent getComponent() {
		return this.component;
	}
}
