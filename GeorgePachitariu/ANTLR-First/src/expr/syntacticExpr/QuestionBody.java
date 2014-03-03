package expr.syntacticExpr;

import typeChecker.ASTVisitor;
import expr.Expr;

public class QuestionBody implements Expr {
	String questionBody;
	
	public QuestionBody(String questionBody) {
		this.questionBody=questionBody;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof QuestionBody))
			return false;
		QuestionBody questionBody=(QuestionBody) obj;
		return this.questionBody.equals(questionBody.questionBody);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.questionBody;
	}
}
