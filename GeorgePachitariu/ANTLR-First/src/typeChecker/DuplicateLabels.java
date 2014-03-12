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

public class DuplicateLabels extends ASTVisitor {
	protected List<Ident> listIdent;
	protected List<Ident> duplicates;	

	public DuplicateLabels() {		
	}

	public List<Ident> check(ASTNode root) {
		this.listIdent=new LinkedList<>();
		this.duplicates=new LinkedList<>();
		root.accept(this);
		return duplicates;
	}
	
	@Override
	public void visit(Question question, Ident ident, 
			QuestionBody questionBody, Type type, Expression expr) {
		ident=question.getIdent();
		if(this.listIdent.contains(ident))
			this.duplicates.add(ident);
		listIdent.add(ident);
	}
}
