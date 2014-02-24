package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Neg;
import org.uva.sea.ql.ast.operators.arithmetic.Pos;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.comparison.Eq;
import org.uva.sea.ql.ast.operators.comparison.GEq;
import org.uva.sea.ql.ast.operators.comparison.GT;
import org.uva.sea.ql.ast.operators.comparison.LEq;
import org.uva.sea.ql.ast.operators.comparison.LT;
import org.uva.sea.ql.ast.operators.comparison.NEq;
import org.uva.sea.ql.ast.operators.logical.And;
import org.uva.sea.ql.ast.operators.logical.Not;
import org.uva.sea.ql.ast.operators.logical.Or;
import org.uva.sea.ql.ast.statement.ExprQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.IfElse;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.QuestionSet;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.*;

public interface IVisitor {
	
	void visit(Add add);
	void visit(Sub sub);
	void visit(Div div);
	void visit(Mul mul);
	void visit(Neg neg);
	void visit(Pos pos);
	
	void visit(Eq eq);
	void visit(GEq geq);
	void visit(GT gt);
	void visit(LEq leq);
	void visit(LT lt);
	void visit(NEq neq);
	
	void visit(And and);
	void visit(Or or);
	void visit(Not not);
	
	void visit(Identifier identifier);
	void visit(Expression expression);
	//void visit(ASTNode e);
	
	void visit(ExprQuestion exprquestion);
	void visit(Question question);
	void visit(If ifconditional);
	void visit(IfElse ifelseconditional);
	void visit(Form form);
	void visit(QuestionSet questionset);
	
	void visit(BoolType bool);
	void visit(IntType integer);
	void visit(StringType string);
	void visit(MoneyType money);
	void visit(Type type);
	void visit(Statement statement);

}
