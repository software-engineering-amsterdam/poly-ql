package gui.observers;

import gui.component.ComputedWidget;
import gui.render.Evaluator;
import gui.render.State;
import ast.statement.ComputedQuestion;
import ast.value.Value;

public class ComputedQuestionObserver extends WidgetObserver{
	
	private ComputedQuestion statement;
	private ComputedWidget widget;
	private State state;

	public ComputedQuestionObserver(ComputedQuestion statement, ComputedWidget widget, State state) {
		this.statement = statement;
		this.widget = widget;
		this.state = state;
	}

	@Override
	public void evaluate() {
		Value val = statement.getExpr().accept(new Evaluator(state.getEnvValues()));
		state.addValue(statement.getId(), val);
		widget.setValue(val);
		widget.getComponent().setVisible(true);
	}

}
