package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.Expr;
import expr.Ident;
import expr.syntacticExpr.Question;

public class CyclicDependenciesChecker extends ASTVisitor {
	
private List<Question> questions;	
private List<Question> dependencies;	
	
	public CyclicDependenciesChecker() {
		this.questions=new LinkedList<>();
		this.dependencies=null;
	}
	
	public List<Question> check(Expr root) {
		 root.accept(this);
	
		 for (Question q: questions) {
			 this.dependencies=new LinkedList<>();
			 this.dependencies.add(q);
			 for(int i=0; i<= this.questions.size()+2; i++)
				 root.accept(this);
			 if(dependencies.size() > this.questions.size())
				 return this.dependencies;
		 }
		 return new LinkedList<>();
	}
	
	@Override
	public void visit(Question q) {
		if(this.dependencies == null)
			this.questions.add(q);
		else {
			Ident lastIdent=this.dependencies.get(dependencies.size()-1).getIdent();
			if(q.hasExpression() &&
					q.getExpression().containsTreeNode(
							lastIdent)
							)
				this.dependencies.add(q);				
		}
	}
}
