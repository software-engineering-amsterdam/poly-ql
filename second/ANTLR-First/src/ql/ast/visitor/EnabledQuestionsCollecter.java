package ql.ast.visitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ql.ast.interpreter.ValueComputer;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.literals.Literal;
import ql.ast.node.syntactic.Form;
import ql.ast.node.syntactic.Label;
import ql.ast.node.syntactic.Statement;
import ql.ast.node.types.Type;
import ql.questionaire.model.answer.Answer;

public class EnabledQuestionsCollecter extends ASTVisitor {
	private List<String> list;
	private Map<String,Answer> answers;

	public EnabledQuestionsCollecter() {
		list=new LinkedList<>();
	}

	public List<String> collect(Map<String,Answer> answers, Form ast) {
		this.answers=answers;	
		ast.accept(this);
		return list;
	}

	private Literal computeExpression(Expression expr) {
		return ValueComputer.compute(expr, answers);
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		list.add(ident.getValue());
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		list.add(ident.getValue());
	}

	@Override
	public void visit(Expression condition, List<Statement> thenStatements) {
		Literal l=computeExpression(condition);
		if(l.hasValue() && l.getValueIfBoolean())
			for(Statement s : thenStatements)
				s.accept(this);
	}

	@Override
	public void visit( Expression condition, List<Statement> thenStatements,
			List<Statement> elseStatements) {
		Literal l=computeExpression(condition);
		if(! l.hasValue())
			return;
		if(l.getValueIfBoolean())
			for(Statement s : thenStatements)
				s.accept(this);
		else
			for(Statement s : elseStatements)
				s.accept(this);		
	}
}
