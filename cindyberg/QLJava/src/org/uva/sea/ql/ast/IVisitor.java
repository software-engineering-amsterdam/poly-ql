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
import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Questions;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;

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
	
	void visit(ExpressionQuestion exprquestion);
	void visit(Question question);
	void visit(IfStatement ifconditional);
	void visit(IfElseStatement ifelseconditional);
	void visit(Form form);
	void visit(Questions questionset);
	
	void visit(BooleanType bool);
	void visit(IntegerType integer);
	void visit(StringType string);
	void visit(Type type);
	void visit(Statement statement);

}
