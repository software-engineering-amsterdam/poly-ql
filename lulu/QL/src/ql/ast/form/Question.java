package ql.ast.form;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.questionType.Type;

public class Question extends FormItems{
	private final Ident id;
	private final String question;
	private final Type type;
	private final Expr expr;
	
	public Question(Ident id, String question, Type type, Expr expr){
		this.id = id;
		this.question = question;
		this.type = type;
		this.expr = expr;
	}
	
	public Question(Ident id, String question, Type type){
		this.id = id;
		this.question = question;
		this.type = type;
		this.expr = null;
	}

	public Ident getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public Type getType() {
		return type;
	}

	public Expr getExpr() {
		return expr;
	}
	
	
}
