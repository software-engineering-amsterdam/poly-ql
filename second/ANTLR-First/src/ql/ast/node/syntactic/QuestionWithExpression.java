package ql.ast.node.syntactic;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;

public class QuestionWithExpression extends Question {
	private Expression expr;

	public QuestionWithExpression(Ident ident, Label label, Type type,
			Expression expr) {
		super(ident,label, type);
		this.expr=expr;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof QuestionWithExpression))
			return false;
		QuestionWithExpression question=(QuestionWithExpression) obj;

		return  expr.equals(question.expr) &&
				ident.equals(question.ident) &&
				label.equals(question.label) &&
				type.equals(question.type);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(ident, label, type, expr);
	}

	public Expression getExpression() {
		return expr; 
	}

	@Override
	public String toString() {
		return super.toString() + "( " + expr + " )";
	}

}
