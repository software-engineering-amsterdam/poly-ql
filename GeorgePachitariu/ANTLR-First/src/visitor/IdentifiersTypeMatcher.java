package visitor;

import java.util.HashMap;
import java.util.Map;

import nodeAST.ASTNode;
import nodeAST.Expression;
import nodeAST.Ident;
import nodeAST.syntactic.Question;
import nodeAST.syntactic.QuestionBody;


import types.Type;


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
