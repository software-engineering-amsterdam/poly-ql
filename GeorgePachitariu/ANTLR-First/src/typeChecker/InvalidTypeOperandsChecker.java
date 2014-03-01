package typeChecker;

import java.util.LinkedList;
import java.util.List;

import expr.Expr;
import expr.Expression;
import expr.arithmeticExpr.Add;
import expr.arithmeticExpr.Div;
import expr.arithmeticExpr.Mul;
import expr.arithmeticExpr.Sub;
import expr.conditionalExpr.And;
import expr.conditionalExpr.Or;
import expr.relationalExpr.Eq;
import expr.relationalExpr.GEq;
import expr.relationalExpr.GT;
import expr.relationalExpr.LEq;
import expr.relationalExpr.LT;
import expr.relationalExpr.NEq;
import expr.signExpr.Neg;
import expr.signExpr.Not;
import expr.signExpr.Pos;

public class InvalidTypeOperandsChecker extends ASTVisitor {

	List<Expression> operandsList;
	
	public InvalidTypeOperandsChecker() {
		this.operandsList = new LinkedList<>();
	}

	public List<Expression> check(Expr root) {
		root.accept(this);
		return this.operandsList;
	}
	
	public void visit(Add add)  {
		if(! add.areOperandsTypeValid())
			this.operandsList.add(add);
	}
	
	public void visit(Div div)  {
		if(! div.areOperandsTypeValid())
			this.operandsList.add(div);
	}
	
	public void visit(Mul mul)  {
		if(! mul.areOperandsTypeValid())
			this.operandsList.add(mul);
	}
	
	public void visit(Sub sub)  {
		if(! sub.areOperandsTypeValid())
			this.operandsList.add(sub);
	}
	
	public void visit(And and)  {
		if(! and.areOperandsTypeValid())
			this.operandsList.add(and);
	}
	
	public void visit(Or or)  {
		if(! or.areOperandsTypeValid())
			this.operandsList.add(or);
	}

	public void visit(Eq eq)  {
		if(! eq.areOperandsTypeValid())
			this.operandsList.add(eq);
	}
	
	public void visit(GEq gEq)  {
		if(! gEq.areOperandsTypeValid())
			this.operandsList.add(gEq);
	}
	
	public void visit(GT gt)  {
		if(! gt.areOperandsTypeValid())
			this.operandsList.add(gt);
	}
	
	public void visit(LEq lEq)  {
		if(! lEq.areOperandsTypeValid())
			this.operandsList.add(lEq);
	}
	
	public void visit(LT lt) {
		if(! lt.areOperandsTypeValid())
			this.operandsList.add(lt);
	}
	
	public void visit(NEq nEq) {
		if(! nEq.areOperandsTypeValid())
			this.operandsList.add(nEq);
	}

	public void visit(Neg neg) {
		if(! neg.areOperandsTypeValid())
			this.operandsList.add(neg);
	}
	
	public void visit(Not not) {
		if(! not.areOperandsTypeValid())
			this.operandsList.add(not);
	}

	public void visit(Pos pos) {
		if(! pos.areOperandsTypeValid())
			this.operandsList.add(pos);
	}
}
