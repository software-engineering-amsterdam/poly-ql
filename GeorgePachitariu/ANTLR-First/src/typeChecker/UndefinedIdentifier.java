package typeChecker;

import java.util.LinkedList;
import java.util.List;

import types.Type;
import visitor.ASTVisitor;

import expr.ASTNode;
import expr.Expression;
import expr.Ident;
import expr.syntactic.Form;
import expr.syntactic.Question;
import expr.syntactic.QuestionBody;
import expr.syntactic.Statement;

public class UndefinedIdentifier extends ASTVisitor {

	protected List<Ident> definedIdentifiers;
	protected List<Ident> expressionIdentifiers;

	public UndefinedIdentifier() {
		this.definedIdentifiers=new LinkedList<>();
		this.expressionIdentifiers=new LinkedList<>();
	}

	public List<Ident> check(ASTNode root) {
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
