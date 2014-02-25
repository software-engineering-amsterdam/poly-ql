package ql.ast;

import ql.ast.expression.*;
import ql.ast.statement.*;
import ql.ast.type.*;
import ql.ast.operator.*;

/**
 * Element (interface) visitor
 */
public interface ElementInterfaceVisitor {
	public void visit(Questionnare questionnare);

	public void visit(ExpressionParentheses expressionParentheses);

	public void visit(OperatorAdd operatorAdd);

	public void visit(OperatorAnd operatorAnd);

	public void visit(OperatorDiv operatorDiv);

	public void visit(OperatorEq operatorEq);

	public void visit(OperatorGt operatorGt);

	public void visit(OperatorGtEq operatorGtEq);

	public void visit(OperatorLt operatorLt);

	public void visit(OperatorLtEq operatorLtEq);

	public void visit(OperatorMod operatorMod);

	public void visit(OperatorMul operatorMul);

	public void visit(OperatorOr operatorOr);

	public void visit(OperatorNeg operatorNeg);

	public void visit(OperatorParentheses operatorParentheses);

	public void visit(OperatorSub operatorSub);
	
	// public void visit(IfStatement s);
	// public void visit(ID);
	
	// and so forth
}
