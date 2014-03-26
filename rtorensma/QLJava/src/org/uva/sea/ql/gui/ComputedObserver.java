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
	private final Input input;
	
	public ComputedObserver(Computed question, ValueEnvironment valueEnv, Input input) {
		this.question = question;
		this.input = input;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update of computed question " + question.getName());
		ValueEnvironment valueEnv = (ValueEnvironment)arg;
		
		Value value = this.question.getExpr().accept(new Evaluator(valueEnv));
		valueEnv.setValueOfIdent(this.question.getName(), value);
		this.input.notifyObservers(valueEnv);
		this.input.setValue(value);
	}
	
	public Computed getQuestion() {
		return question;
	}

	public Input getInput() {
		return input;
	}
}
