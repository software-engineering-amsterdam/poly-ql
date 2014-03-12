package typeChecker;

import java.util.LinkedList;
import java.util.List;

import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;


import expr.ASTNode;
import expr.Expression;
import expr.arithmetic.Add;
import expr.arithmetic.Div;
import expr.arithmetic.Mul;
import expr.arithmetic.Sub;
import expr.conditional.And;
import expr.conditional.Or;
import expr.relational.Eq;
import expr.relational.GEq;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;
import expr.relational.NEq;
import expr.sign.Neg;
import expr.sign.Not;
import expr.sign.Pos;

public class InvalidTypeOperands extends ASTVisitor {

	protected List<Expression> operandsList;
	private IdentifiersTypeMatcher typeMatcher;

	public InvalidTypeOperands() {
		this.operandsList = new LinkedList<>();
		this.typeMatcher=new IdentifiersTypeMatcher();
	}

	public List<Expression> check(ASTNode root) {
		this.typeMatcher.search(root);
		root.accept(this);
		return this.operandsList;
	}

	@Override
	public void visit(Add add, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! add.areOperandsTypeValid(typeMatcher))
			this.recordError(add);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(Div div, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! div.areOperandsTypeValid(typeMatcher))
			this.recordError(div);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(Mul mul, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! mul.areOperandsTypeValid(typeMatcher))
			this.recordError(mul);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(Sub sub, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! sub.areOperandsTypeValid(typeMatcher))
			this.recordError(sub);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(And and, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! and.areOperandsTypeValid(typeMatcher))
			this.recordError(and);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(Or or, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! or.areOperandsTypeValid(typeMatcher))
			this.recordError(or);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(Eq eq, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! eq.areOperandsTypeValid(typeMatcher))
			this.recordError(eq);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(GEq gEq, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! gEq.areOperandsTypeValid(typeMatcher))
			this.recordError(gEq);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(GT gt, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! gt.areOperandsTypeValid(typeMatcher))
			this.recordError(gt);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}
	
	@Override
	public void visit(LEq lEq, Expression leftHandOperand, Expression rightHandOperand)  {
		if(! lEq.areOperandsTypeValid(typeMatcher))
			this.recordError(lEq);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(LT lt, Expression leftHandOperand, Expression rightHandOperand) {
		if(! lt.areOperandsTypeValid(typeMatcher))
			this.recordError(lt);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}

	@Override
	public void visit(NEq nEq, Expression leftHandOperand, Expression rightHandOperand) {
		if(! nEq.areOperandsTypeValid(typeMatcher))
			this.recordError(nEq);
		
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
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
