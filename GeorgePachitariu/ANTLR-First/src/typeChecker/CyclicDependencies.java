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


public class CyclicDependencies extends ASTVisitor {

	protected List<Question> questions;	
	protected List<Question> dependencies;	

	public CyclicDependencies() {
		this.questions=new LinkedList<>();
		this.dependencies=null;
	}

	public void check(ASTNode root) throws Exception {
		List<Question> list = findCycles(root);

		if(list.size()!=0) {
			String message= "ERROR: The following questions form a cycle of dependencies: \n";
			for(Question q: list)
				message+=q.toString()+"\n";
			throw new Exception(message);
		}
	}

	private List<Question> findCycles(ASTNode root) {
		root.accept(this);

		for (Question q: questions) {
			this.dependencies=new LinkedList<>();
			this.dependencies.add(q);
			for(int i=0; i<= this.questions.size()+2; i++)
				root.accept(this);
			if(dependencies.size() > this.questions.size())
				return getFirstCycle(this.dependencies);
		}
		return new LinkedList<>();
	}

	private List<Question> getFirstCycle(List<Question> dependencies) {
		List<Question> returnList=new LinkedList<>();
		for(int i=0; i< dependencies.size(); i++) {
			Question el = dependencies.get(i);
			if(returnList.contains(el)) {
				returnList.add(el);
				break;
			}
			returnList.add(el);
		}
		return returnList;			
	}

	@Override
	public void visit(Question q, Ident ident, 
			QuestionBody questionBody, Type type, Expression expr) {
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
