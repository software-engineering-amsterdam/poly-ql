package expr.syntacticExpr;

import typeChecker.ASTVisitor;
import types.Type;
import expr.Expression;
import expr.Ident;

public class Question extends Statement {
	private Ident ident; 
	private QuestionBody questionBody;
	private Expression expr;
	private Type type;
	

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
		visitor.visit(this);
		this.ident.accept(visitor);
		this.questionBody.accept(visitor);
		this.type.accept(visitor);
		if(this.expr!=null)
			this.expr.accept(visitor);
	}

	public Ident getIdent() {
		return this.ident;
	}

	public Type getType() {
		return this.type;
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
