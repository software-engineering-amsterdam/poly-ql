package ql.ast.node.syntactic;

import java.util.List;

import ql.ast.node.ASTNode;
import ql.ast.node.Ident;
import ql.ast.visitor.ASTVisitor;

public class Form implements ASTNode {
	private Ident identifier;
	private List<Statement> list;

	public Form(Ident identifier, List<Statement> list) {
		this.identifier=identifier;
		this.list=list;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Form))
			return false;
		Form form=(Form) obj;
		return identifier.equals(form.identifier) &&
				list.equals(form.list);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(identifier, list);
	}

	public Ident getIdent() {
		return identifier;
	}

	@Override
	public String toString() {
		String str=" form " +identifier.toString() + "{ \n";
		for(Statement s : list)
			str+=s.toString() + "\n";
		str+= "}";
		return str;
	}
}

