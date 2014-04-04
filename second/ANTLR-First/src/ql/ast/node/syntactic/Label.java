package ql.ast.node.syntactic;

import ql.ast.node.ASTNode;
import ql.ast.visitor.ASTVisitor;

public class Label implements ASTNode {
	private String value;

	public Label(String label) {
		this.value=label;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Label))
			return false;
		Label label=(Label) obj;
		return value.equals(label.value);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "\""+value+"\"";
	}

	public String getValue() {
		return value;
	}
}
