package ql.ast.visitor;

import java.util.Map;

import ql.ast.interpreter.ValueComputer;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.literals.Literal;
import ql.ast.node.syntactic.Label;
import ql.ast.node.syntactic.Question;
import ql.ast.node.types.BoolType;
import ql.ast.node.types.IntType;
import ql.ast.node.types.StringType;
import ql.ast.node.types.Type;
import ql.questionaire.model.answer.Answer;
import ql.questionaire.model.answer.BoolAnswer;
import ql.questionaire.model.answer.IntAnswer;
import ql.questionaire.model.answer.StringAnswer;
import ql.questionaire.model.question.AnswerableQuestion;
import ql.questionaire.model.question.FixedQuestion;
import ql.questionaire.model.question.QuestionModel;

public class QuestionModelBuilder extends ASTVisitor {
	private String ident; 
	private String label;
	private Answer newAnswer;
	private String value;
	private Map<String,Answer>  answers;
	private boolean isFixed;

	public QuestionModel build(Question question, Map<String,Answer> answers) {
		this.answers=answers;
		question.accept(this);
		if(isFixed)			
			return new FixedQuestion(ident, label, newAnswer);
		else
			return new AnswerableQuestion(ident, label, newAnswer); 
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		ident.accept(this);
		label.accept(this);
		visit(expr);       // important to find out if it has a value
		type.accept(this); // before creating the type 
		isFixed=true;
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		ident.accept(this);
		label.accept(this);
		type.accept(this); 
		isFixed=false;
	}

	@Override
	public void visit(Expression expr) {
		Literal val = ValueComputer.compute(expr, answers);
		if(val.hasValue())
			value=val.toString();
		else
			value=null;
	}

	@Override
	public void visit(Ident ident) {
		this.ident=ident.getValue();
	}

	@Override
	public void visit(Label label) {
		this.label=label.getValue();
	}

	@Override
	public void visit(BoolType bool) {
		if(value==null)
			newAnswer=new BoolAnswer();
		else
			newAnswer=new BoolAnswer(Boolean.parseBoolean(value));
	}

	@Override
	public void visit(IntType intType) {
		if(value==null)
			newAnswer=new IntAnswer();
		else
			newAnswer=new IntAnswer(Integer.parseInt(value));
	}

	@Override
	public void visit(StringType stringType) {
		if(value==null)
			newAnswer=new StringAnswer();
		else
			newAnswer=new StringAnswer(value);
	}
}
