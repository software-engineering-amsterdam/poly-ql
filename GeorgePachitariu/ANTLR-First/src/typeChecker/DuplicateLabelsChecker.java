package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.ASTNode;
import expr.Ident;
import expr.syntactic.Question;

public class DuplicateLabelsChecker extends ASTVisitor {
	protected List<Ident> listIdent;
	protected List<Ident> duplicates;	

	public DuplicateLabelsChecker() {		
	}

	public List<Ident> check(ASTNode root) {
		this.listIdent=new LinkedList<>();
		this.duplicates=new LinkedList<>();
		root.accept(this);
		return duplicates;
	}

	@Override
	public void visit(Question question) {
		Ident ident=question.getIdent();
		if(this.listIdent.contains(ident))
			this.duplicates.add(ident);
		listIdent.add(ident);
	}
}
