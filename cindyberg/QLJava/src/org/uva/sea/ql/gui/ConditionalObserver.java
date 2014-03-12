package org.uva.sea.ql.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.evaluate.BooleanValue;
import org.uva.sea.ql.evaluate.EvaluateExpression;
import org.uva.sea.ql.evaluate.Value;

public class ConditionalObserver implements Observer{
	
	private final Expression condition;
	private final State state;
	private final JPanel trueIf;
	private final JPanel falseIf;
	
	public ConditionalObserver(Expression condition, State state, JPanel trueIf, JPanel falseIf){
		this.condition = condition;
		this.state = state;
		this.trueIf = trueIf;
		this.falseIf = falseIf;
	}

	public void update(Observable o, Object arg) {
	 	 Value value = condition.accept(new EvaluateExpression(state.getEnvironment()));
	 	 
	 	 //TODO system.print.outline
	 	 System.out.println(value.getValue().toString());
	 	 boolean visible = value.isDefined() && ((BooleanValue)value).getValue();
	 	 trueIf.setVisible(visible);
	 	 if (falseIf != null) {
			 trueIf.setVisible(!visible);
	 	 }
	 }

}
