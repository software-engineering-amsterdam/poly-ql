package gui.observers;

import gui.Evaluation;
import gui.component.ComputedControl;
import gui.render.State;
import ast.evaluate.Value;
import ast.form.Computedquest;

public class ComputedQuestionObserver extends ControlObserver{

	private Computedquest statement;
	private ComputedControl panel;
	private State state;

	public ComputedQuestionObserver(Computedquest statement, ComputedControl panel, State state) {
		this.statement = statement;
		this.panel = panel;
		this.state = state;
	}

	@Override
	public void evaluate() {
		Value val = statement.getExpr().accept(new Evaluation( state.getEnvValues()));
		panel.setValue(val);
		panel.getComponent().setVisible(true);

	}

}