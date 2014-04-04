package ql.ast.checker;

import java.util.LinkedList;
import java.util.List;

import ql.ast.node.ASTNode;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.syntactic.Label;
import ql.ast.node.syntactic.Statement;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;

public class UndefinedIdentifier extends ASTVisitor {
	private List<Ident> definedIdentifiers;
	private List<Ident> expressionIdentifiers;

	public String check(ASTNode root) {
		this.definedIdentifiers=new LinkedList<>();
		this.expressionIdentifiers=new LinkedList<>();

		List<Ident> list = createListWithUndefinedIdentifiers(root);
		if(list.size()!=0) {
			String message= "ERROR: The following references are not defined: ";
			for(Ident i: list)
				message+=i.toString()+", ";
			message+="\n Also the checking stopped. \n";
			return message;
		}
		return null;
	}

	private List<Ident> createListWithUndefinedIdentifiers(ASTNode root) {
		root.accept(this);
		List<Ident> undefined = new LinkedList<>();
		for(Ident i : expressionIdentifiers)
			if(! definedIdentifiers.contains(i))
				undefined.add(i);
		return undefined;
	}

	@Override
	public void visit(Ident ident) {
		expressionIdentifiers.add(ident);
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		definedIdentifiers.add(ident);
		label.accept(this);
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		definedIdentifiers.add(ident);
		label.accept(this);
		expr.accept(this);
	}

	@Override
	public void visit(Ident ident, List<Statement> list) {
		definedIdentifiers.add(ident);
		for(Statement s : list)
			s.accept(this);
	}
}
