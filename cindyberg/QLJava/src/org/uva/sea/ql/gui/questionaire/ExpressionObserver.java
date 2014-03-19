package org.uva.sea.ql.gui.questionaire;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.evaluate.EvaluateExpression;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.widget.Widget;

public class ExpressionObserver implements Observer {
	 private final Widget widget;
	 private final State state;
	 private final ExpressionQuestion question;
	
	 public ExpressionObserver(Widget widget, State state, ExpressionQuestion question){
		 this.widget = widget;
		 this.state = state;
		 this.question = question;
	 }
	 
	 public void update(Observable o, Object arg) {
		 Value value = question.getExpression().accept(new EvaluateExpression(state.getEnvironment()));
	 	 state.addIdentifier(question.getIdentifier(), value);
	 	 state.notify(question.getIdentifier());
	 	 widget.setValue(value);		
	} 
}
