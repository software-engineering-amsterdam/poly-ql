package gui.observers;

import gui.Evaluator;
import gui.component.Control;
import gui.render.State;

import java.util.Observable;

import ast.expr.evaluate.Value;
import ast.statement.ComputedQuestion;

public class ComputedObserver extends ControlObserver{

	private final ComputedQuestion ques;
	private final Control control;
	private final State state;
	
	public ComputedObserver(ComputedQuestion ques, Control control, State state) {
		this.ques = ques;
		this.control = control;
		this.state = state;
	}

	@Override
	public void evaluate() {
		Value value = ques.getExpr().accept(new Evaluator(state.getEnvValues()));
		control.getComponent().setVisible(true);
	}

}
