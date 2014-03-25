package org.uva.sea.ql.gui;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.eval.Evaluator;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.eval.ValueEnvironment;
import org.uva.sea.ql.gui.inputs.Input;

public class ComputedObserver implements Observer {
	private final Computed question;
	private final ValueEnvironment valueEnv;
	private final Input input;
	
	public ComputedObserver(Computed question, ValueEnvironment valueEnv, Input input) {
		this.question = question;
		this.valueEnv = valueEnv;
		this.input = input;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update of computed question " + question.getName());
		
		Value value = this.question.getExpr().accept(new Evaluator(valueEnv));
		System.out.println(value);
		this.valueEnv.setValueOfIdent(this.question.getName(), value);
		this.input.notifyObservers();
		this.input.setValue(value);
		
	}
	
	public Computed getQuestion() {
		return question;
	}

	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}

	public Input getInput() {
		return input;
	}
}
