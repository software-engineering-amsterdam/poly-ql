package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.comparison.*;
import org.uva.sea.ql.ast.operators.logical.*;

public interface IOperatorVisitor {

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
}
