package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.Expr;
import expr.Ident;
import expr.syntacticExpr.Question;

public class DuplicateLabelsChecker extends ASTVisitor {
	private List<Ident> listIdent;

	public DuplicateLabelsChecker() {
		this.listIdent=new LinkedList<>();
	}

	public List<Ident> check(Expr root) {
		root.accept(this);

		List<Ident> list=new LinkedList<>();
		while(this.listIdent.size()>0) {
			Ident q=this.listIdent.remove(0);
			if (this.listIdent.contains(q))
				list.add(q);
		}
		return list;
	}

	@Override
	public void visit(Question question) {
		listIdent.add(question.getIdent());
	}
}
