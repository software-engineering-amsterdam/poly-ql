package org.uva.sea.ql.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.statement.ExprQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.IfElse;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.QuestionSet;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.Type;

public class StatementChecker implements StatementVisitor {

	private TypeEnvironment environment;
	private List<Error> errorlist;
	
	public StatementChecker(TypeEnvironment environment, List<Error> errorlist){
		
		this.environment = environment;
		this.errorlist = errorlist;
	}
	
	private Boolean expressionCheck(TypeEnvironment environment,
			List<Error> errorlist, Expression expression) {
		
		return ExpressionChecker.checkExpression(environment,errorlist,expression);
		
	}
	
	public void visit(ExprQuestion exprquestion) {
	
		Identifier id = exprquestion.getIdentifier();
		Type type = exprquestion.getType();
		Expression expression = exprquestion.getExpression();
		
		if(environment.isDeclared(id)){
			newError("Variable " + id.show() + " already declared");
		}
		else{
	
		environment.addIdentifier(id, type);
		}
		expressionCheck(environment,errorlist, expression);
		
		if(!expression.typeOf(environment).isCompatibleWith(id.typeOf(environment))){
			newError("Variable " + id.show() + " is not compatible with the expression type " 
					+ expression.typeOf(environment).show());
		}
		
		
	}

	public void visit(Question question) {
		Identifier id = question.getIdentifier();
		Type type = question.getType();

		if(environment.isDeclared(id)){
			newError("Variable " + id.show() + " already declared");
		}
		else{
		environment.addIdentifier(id, type);
		}
		
		
	}

	public void visit(If ifconditional) {
		Expression condition = ifconditional.getConditional();
	
		QuestionSet questionset = ifconditional.getQuestionSet();
		
		if(!condition.typeOf(environment).isCompatibleWithBoolean()){
			newError("The condition " + condition.show() + " is not of type boolean");
		}		

		this.visit(questionset);
		
		
		expressionCheck(environment, errorlist, condition);
		
	}

	public void visit(IfElse ifelseconditional) {
		Expression condition = ifelseconditional.getConditional();
		QuestionSet ifset = ifelseconditional.getIfQuestionSet();
		QuestionSet elseset = ifelseconditional.getElseQuestionSet();

		new ExpressionChecker(environment,errorlist);
		if(!condition.typeOf(environment).isCompatibleWithBoolean()){
			newError(condition.show() + " is not compatible with booleanType");
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
	
	private void newError(String error) {
		errorlist.add(new Error(error));
	}


}
