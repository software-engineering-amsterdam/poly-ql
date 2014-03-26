package org.uva.sea.ql.gui.inputs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.eval.Undefined;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.eval.ValueEnvironment;

public class IntInput extends Input {
	private final JTextField component;

	public IntInput(final Question question, final ValueEnvironment valueEnv, boolean isComputed) {
		super(question, valueEnv, isComputed);
		this.component = new JTextField(10);
		this.component.setEnabled(!isComputed);
		this.component.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("State changed in " + question.getName());
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
				System.out.println("State changed in " + question.getName());
				valueEnv.setValueOfIdent(question.getName(), getValue());
		        setChanged();
		        notifyObservers(valueEnv);
			}
		});
	}

	@Override
	public Value getValue() {
		String txt = this.component.getText();
		try {
			int n = Integer.parseInt(txt);
			return new org.uva.sea.ql.eval.Int(n);
		}
		catch (NumberFormatException e) {
			return new Undefined();
		}
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
