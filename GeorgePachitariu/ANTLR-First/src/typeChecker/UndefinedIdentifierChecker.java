package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.ASTNode;
import expr.Ident;
import expr.syntactic.Form;
import expr.syntactic.Question;

public class UndefinedIdentifierChecker extends ASTVisitor {

	protected List<Ident> definedIdentifiers;
	protected List<Ident> expressionIdentifiers;

	public UndefinedIdentifierChecker() {
		this.definedIdentifiers=new LinkedList<>();
		this.expressionIdentifiers=new LinkedList<>();
	}

	public List<Ident> check(ASTNode root) {
		root.accept(this);
		List<Ident> undefined = new LinkedList<>();
		for(Ident i : this.expressionIdentifiers)
			if(! this.definedIdentifiers.contains(i))
				undefined.add(i);
		return undefined;
	}

	@Override
	public void visit(Ident ident) {
		expressionIdentifiers.add(ident);
	}

	@Override
	public void visit(Question question) {
		definedIdentifiers.add(question.getIdent());
	}

	@Override
	public void visit(Form form) {
		definedIdentifiers.add(form.getIdent());
	}


}
