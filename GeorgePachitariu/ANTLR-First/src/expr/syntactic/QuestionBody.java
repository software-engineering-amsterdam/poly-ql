package expr.syntactic;

import visitor.ASTVisitor;
import expr.ASTNode;

public class QuestionBody implements ASTNode {
	protected String questionBody;

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
