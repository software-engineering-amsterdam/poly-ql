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
import org.uva.sea.ql.ast.type.*;

public class StatementChecker implements StatementVisitor {

	public Environment environment;
	public List<Error> errorlist;
	
	public StatementChecker(Environment environment, List<Error> errorlist){
		
		this.environment = environment;
		this.errorlist = errorlist;
	}
	
	public void visit(ExprQuestion exprquestion) {
		Identifier id = exprquestion.getIdentifier();
		Type type = exprquestion.getType();
		Expression expression = exprquestion.getExpression();
		
		if(environment.isDeclared(id) != null){
			
			errorlist.add(new Error(id.show() + " already declared"));
		}
		
		environment.addIdentifier(id, type);
		new ExpressionChecker(environment,errorlist, expression);
		
		
	}

	public void visit(Question question) {
		Identifier id = question.getIdentifier();
		Type type = question.getType();
		
		if(environment.isDeclared(id) != null){
			
			errorlist.add(new Error(id.show() + " already declared"));
		}
		
		environment.addIdentifier(id, type);
		
	}

	public void visit(If ifconditional) {
		Expression condition = ifconditional.getConditional();
		QuestionSet questionset = ifconditional.getQuestionSet();
		
		this.visit(questionset);
		new ExpressionChecker(environment, errorlist, condition);
		
	}

	public void visit(IfElse ifelseconditional) {
		Expression condition = ifelseconditional.getConditional();
		QuestionSet ifset = ifelseconditional.getIfQuestionSet();
		QuestionSet elseset = ifelseconditional.getElseQuestionSet();

		new ExpressionChecker(environment,errorlist,condition);
		this.visit(ifset);
		this.visit(elseset);
		
	}

	public void visit(Form form) {
		QuestionSet questionset = form.getQuestionSet();
		visit(questionset);
		
	}

	public void visit(QuestionSet questionset) {
		for(Statement s : questionset.getQuestionset()){
			s.accept(this);
		}
		
	}


}
