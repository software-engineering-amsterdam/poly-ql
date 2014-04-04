package ql.ast.visitor;

import java.util.HashMap;
import java.util.Map;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.syntactic.Form;
import ql.ast.node.syntactic.Label;
import ql.ast.node.types.Type;

public class IdentifiersTypeMatcher extends ASTVisitor {

	private Map<Ident,Type> dictionary;

	public IdentifiersTypeMatcher() {
		dictionary=new HashMap<>();
	}

	public void search(Form root) {
		root.accept(this); 
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		dictionary.put(ident, type);
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		dictionary.put(ident, type);
	}

	public Type getIdentType(Ident ident) {
		return dictionary.get(ident);
	}
}
