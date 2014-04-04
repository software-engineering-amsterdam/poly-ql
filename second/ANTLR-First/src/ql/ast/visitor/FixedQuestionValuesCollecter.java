package ql.ast.visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ql.ast.interpreter.ValueComputer;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.literals.Literal;
import ql.ast.node.syntactic.Form;
import ql.ast.node.syntactic.Label;
import ql.ast.node.syntactic.QuestionWithExpression;
import ql.ast.node.syntactic.Statement;
import ql.ast.node.types.Type;
import ql.questionaire.model.answer.Answer;
import ql.questionaire.model.question.QuestionModel;

public class FixedQuestionValuesCollecter extends ASTVisitor {
	private Map<String,Answer> newAnswers;
	private Map<String,Answer> oldAnswers;

	public FixedQuestionValuesCollecter() {
		newAnswers=new HashMap<>();
	}

	public Map<String,Answer> collect(Map<String,Answer> answers, Form ast) {
		oldAnswers=answers;	
		ast.accept(this);
		return newAnswers;
	}

	private Literal computeExpression(Expression expr) {
		return ValueComputer.compute(expr, oldAnswers);
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		QuestionModel q= new QuestionModelBuilder().build(
				new QuestionWithExpression(ident, label, type, expr), oldAnswers);
		newAnswers.put(ident.getValue(), q.getAnswer());

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
