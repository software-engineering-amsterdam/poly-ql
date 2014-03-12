package typeChecker;

import java.util.LinkedList;
import java.util.List;

import types.Type;
import visitor.ASTVisitor;

import expr.ASTNode;
import expr.Expression;
import expr.Ident;
import expr.syntactic.Question;
import expr.syntactic.QuestionBody;

public class DuplicatedIdentifier extends ASTVisitor {
	protected List<Question> exprIdent;

	public DuplicatedIdentifier() {
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
	public void visit(Question question, Ident ident, 
			QuestionBody questionBody, Type type, Expression expr) {
		exprIdent.add(question);
	}
}
