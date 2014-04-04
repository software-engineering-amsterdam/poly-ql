package ql.ast.node.syntactic;

import ql.ast.node.Ident;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;

public class Question extends Statement {
	protected Ident ident; 
	protected Label label;
	protected Type type;

	public Question(Ident ident, Label label, Type type) {
		this.ident = ident;
		this.label = label;
		this.type=type;
	}

	public Label getLabel() {
		return label;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Question))
			return false;
		Question question=(Question) obj;

		return ident.equals(question.ident) &&
				label.equals(question.label) &&
				type.equals(question.type);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(ident, label, type);
	}

	public Ident getIdent() {
		return ident;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		String str = ident.toString()+": " + label.toString() +
				" " + type.toString();
		return str;
	}
}
