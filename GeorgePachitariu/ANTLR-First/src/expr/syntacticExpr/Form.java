package expr.syntacticExpr;

import java.util.List;

import typeChecker.ASTVisitor;

import expr.Expr;
import expr.Ident;

public class Form implements Expr {
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
		return this.identifier.equals(form.identifier) &&
				this.list.equals(form.list);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
		this.identifier.accept(visitor);
		for(Statement s : this.list)
			s.accept(visitor);
	}

	public Ident getIdent() {
		return this.identifier;
	}
	
	@Override
	public String toString() {
		String str=" form " +this.identifier.toString() + "{ \n";
		for(Statement s : this.list)
			str+=s.toString() + "\n";
		str+= "}";
		return str;
	}
}

