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
import ql.ast.statement.StatementAssignmentInterface;
import ql.ast.statement.StatementExpressionAssignment;
import ql.ast.statement.StatementIf;

/** 
 * Type (checker) visitor
 */
public class TypeVisitor implements ElementInterfaceVisitor {

	@Override
	public void visit(Form form) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExpressionParentheses expressionParentheses) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorAdd operatorAdd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorAnd operatorAnd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorDiv operatorDiv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorNeq operatorNeq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorEq operatorEq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorGt operatorGt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorGtEq operatorGtEq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorLt operatorLt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorLtEq operatorLtEq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorMod operatorMod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorMul operatorMul) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorOr operatorOr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorNeg operatorNeg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(OperatorSub operatorSub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementAssignment statementAssignment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(
			StatementExpressionAssignment statementExpressionAssignment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementIf statementIf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralBool literalBool) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralString literalString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LiteralInt literalInt) {
		// TODO Auto-generated method stub
		
	}

	public StatementAssignmentInterface getQuestionAssignmentByTitle(String id) {
		// TODO Auto-generated method stub
		return null;
	}
		
}