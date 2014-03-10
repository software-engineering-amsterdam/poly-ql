package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.ASTNode;
import expr.syntactic.Question;

public class DuplicatedIdentifierChecker extends ASTVisitor {
	protected List<Question> exprIdent;

	public DuplicatedIdentifierChecker() {
		this.exprIdent=new LinkedList<>();
	}

	public List<Question> check(ASTNode root) {
		root.accept(this);

		List<Question> list=new LinkedList<>();
		while(this.exprIdent.size()>0) {
			Question q=this.exprIdent.remove(0);
			for(Question i : this.exprIdent)
				if(  i.getIdent().equals(q.getIdent() ) &&
						(  !i.getType().equals(q.getType()) )
						) {  
					list.add(q);
					list.add(i);
					this.exprIdent.remove(i);
					break;
				}
		}
		return list;
	}

	@Override
	public void visit(Question question) {
		exprIdent.add(question);
	}
}
