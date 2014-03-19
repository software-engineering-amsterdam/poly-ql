package visitor;

import java.util.HashMap;
import java.util.Map;

import types.Type;

import expr.ASTNode;
import expr.Expression;
import expr.Ident;
import expr.syntactic.Question;
import expr.syntactic.QuestionBody;

public class IdentifiersTypeMatcher extends ASTVisitor {

	protected Map<Ident,Type> dictionary;

	public IdentifiersTypeMatcher() {
		this.dictionary=new HashMap<>();
	}

	public void search(ASTNode root) {
		root.accept(this); 
	}
	
	@Override
	public void visit(Question question, Ident ident, 
			QuestionBody questionBody, Type type, Expression expr) {
		this.dictionary.put(ident, type);
	}
	
	public Type getIdentType(Ident ident) {
		return this.dictionary.get(ident);
	}
}
