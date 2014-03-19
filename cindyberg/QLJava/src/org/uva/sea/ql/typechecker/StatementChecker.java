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
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.MissingType;
import org.uva.sea.ql.ast.type.Type;

import problems.CompatibleError;
import problems.DuplicateLabelWarning;
import problems.NotDeclaredError;
import problems.Problems;
import problems.RedeclaredWarning;
import problems.TypeError;

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
	
	private void checkIdentifier(Identifier identifier, Type type) {
		if(environment.isDeclared(identifier)){
			problems.addWarning(new RedeclaredWarning(identifier, type));
		}
		else{
			environment.declareIdentifier(identifier, type);
		}
	}
	
	private void checkLabel(StringLiteral label){
		if(labels.contains(label)){
			problems.addWarning(new DuplicateLabelWarning(label));
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
		ExpressionChecker.checkExpression(environment,problems,expression);
		
		checkIdentifier(id,type);
				
		if(!expression.typeOf(environment).isCompatibleWith(id.typeOf(environment))){
			problems.addError(new CompatibleError(id,expression, environment));
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
		ExpressionChecker.checkExpression(environment,problems,ifConditional.getConditional());
	}

	private void checkConditional(Expression condition) {
		if(condition.typeOf(environment).equals(UNDEFINED)){
			problems.addError(new NotDeclaredError(condition));
		}
		else if(!condition.typeOf(environment).isCompatibleWithBoolean()){
			problems.addError(new TypeError(condition, new BooleanType()));
		}
	}

	public void visit(IfElseStatement ifElseConditional) {
		Expression condition = ifElseConditional.getConditional();
		Questions ifSet = ifElseConditional.getIfBody();
		Questions elseSet = ifElseConditional.getElseBody();

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
		for(Statement s : body){
			s.accept(this);
		}
		
	}


}
