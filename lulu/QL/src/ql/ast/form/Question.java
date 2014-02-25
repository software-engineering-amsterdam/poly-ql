package ql.ast.form;

import ql.ast.expr.ExprType.Expr;
import ql.ast.expr.ExprType.Ident;
import ql.ast.form.QuestionType.Type;

public class Question extends FormItems{
	public final Ident id;
	public final String question;
	public final Type type;
	public final Expr expr;
	
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
}
