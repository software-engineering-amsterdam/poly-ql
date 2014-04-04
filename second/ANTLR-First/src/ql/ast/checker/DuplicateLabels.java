package ql.ast.checker;

import java.util.LinkedList;
import java.util.List;

import ql.ast.node.ASTNode;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.syntactic.Label;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;

public class DuplicateLabels extends ASTVisitor {
	private List<Label> listIdent;
	private List<Label> duplicates;	

	public void check(ASTNode root) {
		listIdent=new LinkedList<>();
		duplicates=new LinkedList<>();
		root.accept(this);

		if(duplicates.size()!=0) {
			String message= "WARNING: The following Labels are duplicated: \n";
			for(Label l: duplicates)
				message+=l.toString()+"\n";
			System.out.println(message);
		}
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		if(listIdent.contains(label))
			duplicates.add(label);
		listIdent.add(label);
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		if(listIdent.contains(label))
			duplicates.add(label);
		listIdent.add(label);
	}
}
