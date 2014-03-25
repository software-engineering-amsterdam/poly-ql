package ql.ast.form;

import javax.swing.JPanel;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Expr;
import ql.ast.expr.exprType.Ident;
import ql.ast.type.Type;
import ql.ast.value.Value;
import ql.ast.message.Error;

public class ComputedQuestion extends Question{
	private final Expr expr;
	
	public ComputedQuestion(Ident ident, String question, Type type, Expr expr) {
		super(ident, question,type);
		this.expr = expr;
	}
	
	public Expr getExpression() {
		return expr;
	}
	
	@Override
	public boolean validate(Environment environment) {
		boolean valid = super.validate(environment);
		if(valid){
			errors.addAll(expr.checkType(environment));	
			if (expr.getType(environment) != null && expr.getType(environment).getClass() != getType().getClass()) {
				errors.add(new Error("" +
						"The type of question " + getIdent() + "(" + getType() + ")" +
						" is not compatible with the type of expression (" + expr.getType(environment) + ")"));
			}
			
			return errors.size() == 0;
		}

		else return false;
	}
	
	@Override
	public void buildForm(JPanel panel, Environment environment, Form form) {
		panel.add(super.getQuestionLabel());
		panel.add(super.getAnswerComponent().getAnswerField(false, environment, form, super.getIdent()), "span");
	}
	
	@Override
	public void eval(Environment environment) {
		Value exprValue = expr.eval(environment);
		getAnswerComponent().setAnswerValue(exprValue);
		environment.addValue(getIdent(), exprValue);
	}
}
