package ql.ast.form;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.questionType.TypeQue;

public class Question extends FormItems{
	private final Ident id;
	private final String question;
	private final TypeQue type;
	private final Expr expr;
	
	public Question(Ident id, String question, TypeQue type, Expr expr){
		this.id = id;
		this.question = question;
		this.type = type;
		this.expr = expr;
	}
	
	public Question(Ident id, String question, TypeQue type){
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

	public TypeQue getType() {
		return type;
	}

	public Expr getExpr() {
		return expr;
	}
	
	
}
