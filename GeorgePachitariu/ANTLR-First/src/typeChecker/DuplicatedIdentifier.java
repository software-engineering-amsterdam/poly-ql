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


public class DuplicatedIdentifier extends ASTVisitor {
	protected List<Question> exprIdent;

	public DuplicatedIdentifier() {
		this.exprIdent=new LinkedList<>();
	}

	public void check(ASTNode root) throws Exception {
		List<Question> list = buildListWithDuplicatedIdentifiers(root);

		if(list.size()!=0) {
			String message= "ERROR: The following questions have the same question " +
					"declaration but with different types \n";
			for(Question q: list)
				message+=q.toString()+"\n";
			throw new Exception(message);
		}
	}

	private List<Question> buildListWithDuplicatedIdentifiers(ASTNode root) {
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
