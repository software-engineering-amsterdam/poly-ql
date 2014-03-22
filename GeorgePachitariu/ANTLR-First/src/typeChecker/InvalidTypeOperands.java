package typeChecker;

import java.util.LinkedList;
import java.util.List;

import nodeAST.ASTNode;
import nodeAST.Expression;
import nodeAST.arithmetic.Add;
import nodeAST.arithmetic.Div;
import nodeAST.arithmetic.Mul;
import nodeAST.arithmetic.Sub;
import nodeAST.conditional.And;
import nodeAST.conditional.Or;
import nodeAST.relational.Eq;
import nodeAST.relational.GEq;
import nodeAST.relational.GT;
import nodeAST.relational.LEq;
import nodeAST.relational.LT;
import nodeAST.relational.NEq;


import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;


import nodeAST.sign.Neg;
import nodeAST.sign.Not;
import nodeAST.sign.Pos;

public class InvalidTypeOperands extends ASTVisitor {

	protected List<Expression> operandsList;
	private IdentifiersTypeMatcher typeMatcher;

	public InvalidTypeOperands() {
		this.operandsList = new LinkedList<>();
		this.typeMatcher=new IdentifiersTypeMatcher();
	}

	public void check(ASTNode root) throws Exception {
		this.typeMatcher.search(root);
		root.accept(this);

		if(operandsList.size()!=0) {
			String message= "ERROR: The following expressions contain operands of invalid" +
					" type to operators: \n";
			for(Expression e: operandsList)
				message+=e.toString()+"\n";
			throw new Exception(message);
		}
	}

	private void visitBoth(Expression leftHandOperand, Expression rightHandOperand) {
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(Add add, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! add.areOperandsTypeValid(typeMatcher))
			this.recordError(add);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(Div div, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! div.areOperandsTypeValid(typeMatcher))
			this.recordError(div);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(Mul mul, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! mul.areOperandsTypeValid(typeMatcher))
			this.recordError(mul);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(Sub sub, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! sub.areOperandsTypeValid(typeMatcher))
			this.recordError(sub);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(And and, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! and.areOperandsTypeValid(typeMatcher))
			this.recordError(and);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(Or or, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! or.areOperandsTypeValid(typeMatcher))
			this.recordError(or);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(Eq eq, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! eq.areOperandsTypeValid(typeMatcher))
			this.recordError(eq);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(GEq gEq, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! gEq.areOperandsTypeValid(typeMatcher))
			this.recordError(gEq);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(GT gt, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! gt.areOperandsTypeValid(typeMatcher))
			this.recordError(gt);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(LEq lEq, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! lEq.areOperandsTypeValid(typeMatcher))
			this.recordError(lEq);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(LT lt, Expression leftHandOperand, Expression rightHandOperand) {
		if(! lt.areOperandsTypeValid(typeMatcher))
			this.recordError(lt);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(NEq nEq, Expression leftHandOperand, Expression rightHandOperand) {
		if(! nEq.areOperandsTypeValid(typeMatcher))
			this.recordError(nEq);
		visitBoth(leftHandOperand, rightHandOperand);
	}

	@Override
	public void visit(Neg neg, Expression operand) {
		if(! neg.areOperandsTypeValid(typeMatcher))
			this.recordError(neg);
		operand.accept(this);
	}

	@Override
	public void visit(Not not, Expression operand) {
		if(! not.areOperandsTypeValid(typeMatcher))
			this.recordError(not);
		operand.accept(this);
	}

	@Override
	public void visit(Pos pos, Expression operand) {
		if(! pos.areOperandsTypeValid(typeMatcher))
			this.recordError(pos);
		operand.accept(this);
	}

	private boolean recordError(Expression exp) {
		return this.operandsList.add(exp);
	}
}
