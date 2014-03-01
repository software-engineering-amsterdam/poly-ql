package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.Expr;
import expr.Ident;
import expr.syntacticExpr.Question;

public class IdentifiersTypeMatcher extends ASTVisitor {
	
	List<Ident> identList;
	
	public IdentifiersTypeMatcher() {
		this.identList = new LinkedList<>();
	}

	public void match(Expr root) {
		// first time the list gets created 
		root.accept(this);
		// second time all the identifiers are matched
		root.accept(this);
	}
	
	public void visit(Ident ident) {
		for(Ident i : identList)
			if(i.toString().equals(ident.toString()))
				ident.setType(i.getType());
	}
	
	@Override
	public void visit(Question question) {
		Ident ident=question.getIdent();
		ident.setType(question.getType());
		this.identList.add(ident);
	}

}
