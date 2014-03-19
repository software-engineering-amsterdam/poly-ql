package typeChecker;

import java.util.LinkedList;
import java.util.List;

import nodeAST.ASTNode;
import nodeAST.Expression;
import nodeAST.Ident;
import nodeAST.syntactic.Question;
import nodeAST.syntactic.QuestionBody;


import types.Type;
import visitor.ASTVisitor;


public class DuplicateLabels extends ASTVisitor {
	protected List<Ident> listIdent;
	protected List<Ident> duplicates;	

	public DuplicateLabels() {		
	}

	public void check(ASTNode root) {
		this.listIdent=new LinkedList<>();
		this.duplicates=new LinkedList<>();
		root.accept(this);
		
		if(duplicates.size()!=0) {
			String message= "WARNING: The following Labels are duplicated: \n";
			for(Ident i: duplicates)
				message+=i.toString()+"\n";
			System.err.println(message);
		}
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
