package typeChecker;

import java.util.LinkedList;
import java.util.List;

import nodeAST.ASTNode;
import nodeAST.Expression;
import nodeAST.Ident;
import nodeAST.syntactic.Form;
import nodeAST.syntactic.Question;
import nodeAST.syntactic.QuestionBody;
import nodeAST.syntactic.Statement;


import types.Type;
import visitor.ASTVisitor;


public class UndefinedIdentifier extends ASTVisitor {

	protected List<Ident> definedIdentifiers;
	protected List<Ident> expressionIdentifiers;

	public UndefinedIdentifier() {
		this.definedIdentifiers=new LinkedList<>();
		this.expressionIdentifiers=new LinkedList<>();
	}

	public void check(ASTNode root) throws Exception {
		List<Ident> list = createListWithUndefinedIdentifiers(root);
		if(list.size()!=0) {
			String message= "ERROR: The following references are not defined: ";
			for(Ident i: list)
				message+=i.toString()+", ";
			throw new Exception(message);
		}
	}

	private List<Ident> createListWithUndefinedIdentifiers(ASTNode root) {
		root.accept(this);
		List<Ident> undefined = new LinkedList<>();
		for(Ident i : this.expressionIdentifiers)
			if(! this.definedIdentifiers.contains(i))
				undefined.add(i);
		return undefined;
	}

	@Override
	public void visit(Ident ident) {
		expressionIdentifiers.add(ident);
	}

	@Override
	public void visit(Question question, Ident ident, 
			QuestionBody questionBody, Type type, Expression expr) {
		definedIdentifiers.add(question.getIdent());

		questionBody.accept(this);
		if(expr!=null)
			expr.accept(this);
	}

	@Override
	public void visit(Form form, List<Statement> list) {
		definedIdentifiers.add(form.getIdent());

		for(Statement s : list)
			s.accept(this);
	}
}
