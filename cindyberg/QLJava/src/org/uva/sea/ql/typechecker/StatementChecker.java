package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Questions;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.MissingType;
import org.uva.sea.ql.ast.type.Type;

public class StatementChecker implements StatementVisitor {

	private TypeEnvironment environment;
	private Problems problems;
	private List<StringLiteral> labels;
	private MissingType UNDEFINED = new MissingType();
	
	public StatementChecker(TypeEnvironment environment, Problems problems){
		this.environment = environment;
		this.problems = problems;
		labels = new ArrayList<StringLiteral>();
	}
	
	private static Boolean expressionCheck(TypeEnvironment environment,
			Problems problems, Expression expression) {
		
		return ExpressionChecker.checkExpression(environment,problems,expression);
		
	}
	
	private void checkIdentifier(Identifier id, Type type) {
		if(environment.isDeclared(id)){
			if(environment.ofType(id).equals(type)){
				problems.addWarning("Redeclaration of Identifier " +  id.toString());
			}
			else{
				problems.addWarning("Identifier " + id.toString() + " is already declared with type " + environment.ofType(id).toString());
			}
		}
		else{
			environment.declareIdentifier(id, type);
		}
	}
	
	private void checkLabel(StringLiteral label){
		if(labels.contains(label)){
			problems.addWarning("question [" + label.toString() + "] already exists");
		}
		else{
			labels.add(label);
		}
	}
	
	public void visit(ExpressionQuestion exprquestion) {
	
		Identifier id = exprquestion.getIdentifier();
		Type type = exprquestion.getType();
		Expression expression = exprquestion.getExpression();
		StringLiteral label = exprquestion.getLabel();
		
		checkLabel(label);
		expressionCheck(environment, problems, expression);
		
		checkIdentifier(id,type);
				
		if(!expression.typeOf(environment).isCompatibleWith(id.typeOf(environment))){
			problems.addError("Identifier " + id.toString() + " is not compatible with the expression type " 
					+ expression.typeOf(environment).toString());
		}
	}

	public void visit(Question question) {
		Identifier id = question.getIdentifier();
		Type type = question.getType();
		StringLiteral label = question.getLabel();

		checkLabel(label);
		checkIdentifier(id, type);	
	}

	public void visit(IfStatement ifConditional) {
		Expression condition = ifConditional.getConditional();
		Questions body = ifConditional.getIfBody();
		
		checkConditional(condition);		

		this.visit(body);
		expressionCheck(environment, problems, condition);
		
	}

	private void checkConditional(Expression condition) {
		if(condition.typeOf(environment).equals(UNDEFINED)){
			problems.addError(condition.toString() + " is not declared");
		}
		else if(!condition.typeOf(environment).isCompatibleWithBoolean()){
			problems.addError("The condition " + condition.toString() + " is not of type boolean");
		}
	}

	public void visit(IfElseStatement ifElseConditional) {
		Expression condition = ifElseConditional.getConditional();
		Questions ifSet = ifElseConditional.getIfQuestionSet();
		Questions elseSet = ifElseConditional.getElseQuestionSet();

		new ExpressionChecker(environment, problems);
		
		checkConditional(condition);
		
		ifSet.accept(this);
		elseSet.accept(this);
	}

	public void visit(Form form) {
		Questions body = form.getBody();
		this.visit(body);
		
	}

	public void visit(Questions body) {
		for(Statement s : body.getQuestions()){
			s.accept(this);
		}
		
	}


}
