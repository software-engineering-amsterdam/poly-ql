package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.comparison.*;
import org.uva.sea.ql.ast.operators.logical.*;

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
	
	T visit(IntegerLiteral intLiteral);
	T visit(BooleanLiteral boolLiteral);
	T visit(StringLiteral stringLiteral);
	T visit(Identifier identifier);
	
}
