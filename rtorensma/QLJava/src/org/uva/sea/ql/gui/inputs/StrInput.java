package org.uva.sea.ql.gui.inputs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.eval.ValueEnvironment;

public class StrInput extends Input {
	private final JTextField component;

	public StrInput(final Question question, final ValueEnvironment valueEnv, boolean isComputed) {
		super(question, valueEnv, isComputed);
		this.component = new JTextField(20);
		this.component.setEnabled(!isComputed);
		this.component.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				valueEnv.setValueOfIdent(question.getName(), getValue());
		        setChanged();
		        notifyObservers(valueEnv);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		this.component.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valueEnv.setValueOfIdent(question.getName(), getValue());
		        setChanged();
		        notifyObservers(valueEnv);
			}
		});
	}

	@Override
	public Value getValue() {
		return new org.uva.sea.ql.eval.Str(this.component.getText());
	}
	
	@Override
	public void setValue(Value value) {
		this.component.setText(value.toString());
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}
}
