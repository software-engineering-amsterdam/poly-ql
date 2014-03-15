package gui.observers;

import gui.Evaluator;
import gui.component.Control;
import gui.render.State;

import java.util.Observable;
import java.util.Observer;

import ast.expr.evaluate.Value;
import ast.statement.ComputedQuestion;

public class ComputedObserver implements Observer{

	private final Control control;
	private final State state;
	private final ComputedQuestion ques;
	
	public ComputedObserver(Control control, State state, ComputedQuestion ques) {
		this.control = control;
		this.state = state;
		this.ques = ques;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Value value = ques.getExpr().accept(new Evaluator(state.getEnvValues()));
		state.putValue(ques.getId(), value);
		state.notify(ques.getId());
//		control.setValue(value);
		
	}

}
