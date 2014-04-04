package ql.ast.visitor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.syntactic.Form;
import ql.ast.node.syntactic.Label;
import ql.ast.node.syntactic.Question;
import ql.ast.node.syntactic.QuestionWithExpression;
import ql.ast.node.types.Type;
import ql.questionaire.model.answer.Answer;
import ql.questionaire.model.question.QuestionModel;

public class AllQuestionsCollecter extends ASTVisitor {
	private List<QuestionModel> list;
	private QuestionModelBuilder builder;

	public AllQuestionsCollecter() {
		list=new LinkedList<>();
		builder=new QuestionModelBuilder();
	}

	public List<QuestionModel> collect(Form ast) {
		ast.accept(this);
		return list;
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		QuestionModel question = builder.build(
				new Question(ident, label, type),
				new HashMap<String,Answer>());
		list.add(question);
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		QuestionModel question = builder.build(
				new QuestionWithExpression(ident, label, type, expr), 
				new HashMap<String,Answer>());
		list.add(question);
	}
}
