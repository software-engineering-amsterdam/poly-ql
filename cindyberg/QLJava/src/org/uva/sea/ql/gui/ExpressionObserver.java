package org.uva.sea.ql.gui;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.evaluate.EvaluateExpression;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.widget.Control;

public class ExpressionObserver implements Observer {
	 private final Control control;
	 private final State state;
	 private final ExpressionQuestion question;
	
	 public ExpressionObserver(Control control, State state, ExpressionQuestion question){
		 this.control = control;
		 this.state = state;
		 this.question = question;
	 }
	 
	 public void update(Observable o, Object arg) {
		 Value value = question.getExpression().accept(new EvaluateExpression(state.getEnvironment()));
	 	 state.putVariable(question.getIdentifier(), value);
	 	 state.notify(question.getIdentifier());
	 	 control.setValue(value);
		
	}
	 
	 
}
