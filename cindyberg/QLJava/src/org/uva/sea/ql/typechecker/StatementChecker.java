package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.QuestionSet;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.Type;

public class StatementChecker implements StatementVisitor {

	private TypeEnvironment environment;
	private Problems problems;
	private List<String> labels;
	
	public StatementChecker(TypeEnvironment environment, Problems problems){
		
		this.environment = environment;
		this.problems = problems;
		labels = new ArrayList<String>();
	}
	
	private Boolean expressionCheck(TypeEnvironment environment,
			Problems problems, Expression expression) {
		
		return ExpressionChecker.checkExpression(environment,problems,expression);
		
	}
	
	private void declareIdentifier(Identifier id, Type type) {
		if(environment.isDeclared(id)){
			if(environment.getType(id).show() == type.show()){
				problems.addWarnings("Redeclaration of variable " +  id.show());
			}
			else{
				problems.addWarnings("Variable " + id.show() + " is already declared with type " + environment.getType(id).show());
			}
		}
		else{
		environment.addIdentifier(id, type);
		}
	}
	
	private void checkLabel(StringLiteral label){
		if(labels.contains(label.show())){
			problems.addWarnings("question [" + label.show() + "] already exists");
		}
		else{
			labels.add(label.show());
		}
	}
	
	public void visit(ExpressionQuestion exprquestion) {
	
		Identifier id = exprquestion.getIdentifier();
		Type type = exprquestion.getType();
		Expression expression = exprquestion.getExpression();
		StringLiteral label = exprquestion.getLabel();
		
		checkLabel(label);
		declareIdentifier(id,type);
		
		expressionCheck(environment, problems, expression);
		
		if(!expression.typeOf(environment).isCompatibleWith(id.typeOf(environment))){
			problems.addError("Variable " + id.show() + " is not compatible with the expression type " 
					+ expression.typeOf(environment).show());
		}
		
		
	}

	public void visit(Question question) {
		Identifier id = question.getIdentifier();
		Type type = question.getType();
		StringLiteral label = question.getLabel();

		checkLabel(label);
		declareIdentifier(id, type);
		
		
	}

	public void visit(IfStatement ifconditional) {
		Expression condition = ifconditional.getConditional();
	
		QuestionSet questionset = ifconditional.getQuestionSet();
		
		if(!condition.typeOf(environment).isCompatibleWithBoolean()){
			problems.addError("The condition " + condition.show() + " is not of type boolean");
		}		

		this.visit(questionset);
		
		
		expressionCheck(environment, problems, condition);
		
	}

	public void visit(IfElseStatement ifelseconditional) {
		Expression condition = ifelseconditional.getConditional();
		QuestionSet ifset = ifelseconditional.getIfQuestionSet();
		QuestionSet elseset = ifelseconditional.getElseQuestionSet();

		new ExpressionChecker(environment, problems);
		if(!condition.typeOf(environment).isCompatibleWithBoolean()){
			problems.addError(condition.show() + " is not compatible with booleanType");
		}
		
		this.visit(ifset);
		this.visit(elseset);
		
		
		
	}

	public void visit(Form form) {
		QuestionSet questionset = form.getQuestionSet();
		this.visit(questionset);
		
	}

	public void visit(QuestionSet questionset) {
		for(Statement s : questionset.getQuestionset()){
			s.accept(this);
		}
		
	}


}
