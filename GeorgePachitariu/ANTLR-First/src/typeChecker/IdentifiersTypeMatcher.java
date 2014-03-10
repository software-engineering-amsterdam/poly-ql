package typeChecker;

import java.util.HashMap;
import java.util.Map;

import types.Type;

import expr.ASTNode;
import expr.Ident;
import expr.syntactic.Question;

public class IdentifiersTypeMatcher extends ASTVisitor {

	protected Map<Ident,Type> dictionary;

	public IdentifiersTypeMatcher() {
		this.dictionary=new HashMap<>();
	}

	public void match(ASTNode root) {
		root.accept(this); 
	}

	@Override
	public void visit(Question question) {
		Ident ident=question.getIdent();
		Type type=question.getType();
		this.dictionary.put(ident, type);
	}
	
	public Type getIdentType(Ident ident) {
		return this.dictionary.get(ident);
	}
}
