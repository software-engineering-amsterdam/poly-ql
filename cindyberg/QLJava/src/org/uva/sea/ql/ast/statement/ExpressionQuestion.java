package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class ExpressionQuestion extends Question{
	
	//private final Identifier name;
	//private final StringLiteral label;
	//private final Type type;
	private final Expression expression;

	public ExpressionQuestion(Identifier questionname, StringLiteral label,
			Type type, Expression expr) {
		super(questionname,label,type);
		//this.name = questionname;
		//this.label = label;
		//this.type = type;
		this.expression = expr;	
		
	}
	
/*	public Identifier getIdentifier(){
		return this.name;
	}
	
	public StringLiteral getLabel(){
		return this.label;
	}
	
	public Type getType(){
		return this.type;
	}*/
	
	public Expression getExpression(){
		return this.expression;
	}


	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
		
	}

}
