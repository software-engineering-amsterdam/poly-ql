package org.uva.sea.ql.gui.inputs;

import java.util.Observable;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.eval.ValueEnvironment;

public abstract class Input extends Observable {
	private final Question question;
	private final ValueEnvironment valueEnv;
	private final boolean isComputed;
	
	public Input(Question question, ValueEnvironment valueEnv, boolean isComputed) {
		this.question = question;
		this.valueEnv = valueEnv;
		this.isComputed = isComputed;
	}
	
	@Override
	public void notifyObservers(Object arg) {
		if (this.isComputed) {
			setChanged();
		}
		super.notifyObservers(arg);
	}
	
	public abstract Value getValue();
	public abstract void setValue(Value value);
	public abstract JComponent getComponent();
	
	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}

	public Question getQuestion() {
		return question;
	}

	public boolean isComputed() {
		return isComputed;
	}
}
