package org.uva.sea.ql.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.eval.Bool;
import org.uva.sea.ql.eval.Evaluator;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.eval.ValueEnvironment;

public class ConditionalObserver implements Observer {
	private final Expr condition;
	private final JPanel trueQuestions;
	private final JPanel falseQuestions;
	
	public ConditionalObserver(Expr condition, ValueEnvironment valueEnv, JPanel trueQuestions, JPanel falseQuestions) {
		this.condition = condition;
		this.trueQuestions = trueQuestions;
		this.falseQuestions = falseQuestions;
	}

	@Override
	public void update(Observable o, Object arg) {
		ValueEnvironment valueEnv = (ValueEnvironment)arg;
		
		Value value = this.condition.accept(new Evaluator(valueEnv));
		boolean conditionValue;
		if (value.getClass() == Bool.class) {
			conditionValue = ((Bool)value).getValue();
		}
		else {
			conditionValue = false;
		}
		this.trueQuestions.setVisible(conditionValue);
		this.falseQuestions.setVisible(!conditionValue);
	}

	public JPanel getTrueQuestions() {
		return trueQuestions;
	}

	public JPanel getFalseQuestions() {
		return falseQuestions;
	}
}
