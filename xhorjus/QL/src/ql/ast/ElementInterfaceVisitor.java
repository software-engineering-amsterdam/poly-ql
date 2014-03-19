package ql.ast;

import ql.ast.expression.ExpressionParentheses;
import ql.ast.literal.LiteralBool;
import ql.ast.literal.LiteralInt;
import ql.ast.literal.LiteralString;
import ql.ast.operator.OperatorAdd;
import ql.ast.operator.OperatorAnd;
import ql.ast.operator.OperatorDiv;
import ql.ast.operator.OperatorEq;
import ql.ast.operator.OperatorGt;
import ql.ast.operator.OperatorGtEq;
import ql.ast.operator.OperatorLt;
import ql.ast.operator.OperatorLtEq;
import ql.ast.operator.OperatorMod;
import ql.ast.operator.OperatorMul;
import ql.ast.operator.OperatorNeg;
import ql.ast.operator.OperatorNeq;
import ql.ast.operator.OperatorOr;
import ql.ast.operator.OperatorSub;
import ql.ast.statement.StatementAssignment;
import ql.ast.statement.StatementExpressionAssignment;
import ql.ast.statement.StatementIf;

/**
 * Element (interface) visitor
 */
public interface ElementInterfaceVisitor {
	/* Questionnares */
	public void visit(Form form);

	/* Expressions */
	public void visit(ExpressionParentheses expressionParentheses);

	/* Operators */
	public void visit(OperatorAdd operatorAdd);
	public void visit(OperatorAnd operatorAnd);
	public void visit(OperatorDiv operatorDiv);
	public void visit(OperatorNeq operatorNeq);	
	public void visit(OperatorEq operatorEq);
	public void visit(OperatorGt operatorGt);
	public void visit(OperatorGtEq operatorGtEq);
	public void visit(OperatorLt operatorLt);
	public void visit(OperatorLtEq operatorLtEq);
	public void visit(OperatorMod operatorMod);
	public void visit(OperatorMul operatorMul);
	public void visit(OperatorOr operatorOr);
	public void visit(OperatorNeg operatorNeg);
	public void visit(OperatorSub operatorSub);

	/* Statements */
	public void visit(StatementAssignment statementAssignment);
	public void visit(StatementExpressionAssignment statementExpressionAssignment);	
	public void visit(StatementIf statementIf);

	/* Literals */
	public void visit(LiteralBool literalBool);
	public void visit(LiteralString literalString);
	public void visit(LiteralInt literalInt);

	
}
