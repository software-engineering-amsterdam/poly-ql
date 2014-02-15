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

public interface ExpressionVisitor<T>{

	
	T visit(Add add);
	T visit(Sub sub);
	T visit(Div div);
	T visit(Mul mul);
	T visit(Neg neg);
	T visit(Pos pos);
	
	T visit(Eq eq);
	T visit(GEq geq);
	T visit(GT gt);
	T visit(LEq leq);
	T visit(LT lt);
	T visit(NEq neq);
	
	T visit(And and);
	T visit(Or or);
	T visit(Not not);
	
}
