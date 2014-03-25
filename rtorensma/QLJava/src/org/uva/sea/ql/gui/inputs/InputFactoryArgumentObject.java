package org.uva.sea.ql.gui.inputs;

import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.eval.ValueEnvironment;

public class InputFactoryArgumentObject {
	private final Question question;
	private final boolean isComputed;
	private final ValueEnvironment valueEnv;
	
	public InputFactoryArgumentObject(Question question, ValueEnvironment valueEnv, boolean isComputed) {
		this.question = question;
		this.valueEnv = valueEnv;
		this.isComputed = isComputed;
	}

	public Question getQuestion() {
		return question;
	}

	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}

	public boolean isComputed() {
		return isComputed;
	}
}
