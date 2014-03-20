package nodeAST.syntactic;

import nodeAST.Expression;
import nodeAST.Ident;
import types.Type;
import visitor.ASTVisitor;

public class Question extends Statement {
	protected Ident ident; 
	protected QuestionBody questionBody;
	protected Expression expr;
	protected Type type;


	public Question(Ident ident, QuestionBody questionBody, Type type,
			Expression expr) {
		super();
		this.ident = ident;
		this.questionBody = questionBody;
		this.expr = expr;
		this.type=type;
	}

	public Question(Ident ident, QuestionBody questionBody, Type type) {
		super();
		this.ident = ident;
		this.questionBody = questionBody;
		this.expr=null;
		this.type=type;
	}

	public QuestionBody getQuestionBody() {
		return questionBody;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Question))
			return false;
		Question question=(Question) obj;
		if(this.expr != null)
			if(question.expr == null)
				return false;
			else if(! this.expr.equals(question.expr))
				return false;
		if(this.expr == null && question.expr != null)
			return false;


		return this.ident.equals(question.ident) &&
				this.questionBody.equals(question.questionBody) &&
				this.type.equals(question.type);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, this.ident, this.questionBody, this.type, this.expr);
	}

	public Ident getIdent() {
		return this.ident;
	}

	public Type getType() {
		return this.type;
	}

	public void setExpression(Expression e) {
		this.expr=e; 
	}

	public Expression getExpression() {
		return this.expr; 
	}

	@Override
	public String toString() {
		String str = this.ident.toString()+": " + this.questionBody.toString() +
				" " + this.type.toString();
		if(this.expr != null)
			str+= "( " + this.expr + " )";
		return str;
	}

	public boolean hasExpression() {
		if(this.expr!=null)
			return true;
		return false;
	}
}
