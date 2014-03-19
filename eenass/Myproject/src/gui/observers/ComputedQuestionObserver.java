package gui.observers;

import gui.Evaluator;
import gui.component.ComputedControl;
import gui.render.State;
import ast.expr.evaluate.Int;
import ast.expr.evaluate.Value;
import ast.statement.ComputedQuestion;

public class ComputedQuestionObserver extends ControlObserver{
	
	private ComputedQuestion statement;
	private ComputedControl panel;
	private State state;

	public ComputedQuestionObserver(ComputedQuestion statement, ComputedControl panel, State state) {
		this.statement = statement;
		this.panel = panel;
		this.state = state;
	}

	@Override
	public void evaluate() {
		Value val = statement.getExpr().accept(new Evaluator(state.getEnvValues()));
		System.out.println("computed value " + ((Int) val).getValue());
		panel.setValue(val);
		panel.getComponent().setVisible(true);
		
	}

}
