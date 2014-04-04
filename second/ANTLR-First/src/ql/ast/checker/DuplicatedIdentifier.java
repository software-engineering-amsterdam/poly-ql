package ql.ast.checker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ql.ast.node.ASTNode;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.syntactic.Label;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;

public class DuplicatedIdentifier extends ASTVisitor {
	private Map<Ident,Type> identifiers;
	private List<Ident> duplIdentList;

	public String check(ASTNode root) {
		identifiers=new HashMap<>();
		duplIdentList=new LinkedList<>();

		root.accept(this);

		if(! duplIdentList.isEmpty()) {
			String message= "ERROR: The following question identifiers " +
					"have multiple declarations with different types";
			for(Ident ident: duplIdentList) {
				message+=ident.toString()+"\n";
			}
			return message;
		}
		return null;
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		checkPair(ident, type);
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		checkPair(ident, type);
	}

	private void checkPair(Ident ident, Type type) {
		Type t = identifiers.get(ident);
		if(t == null) {
			identifiers.put(ident,type);
		}
		else {
			if(! t.equals(type))
				duplIdentList.add(ident);
		}
	}
}
