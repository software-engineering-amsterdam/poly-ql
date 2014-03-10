package typeChecker;

import java.util.LinkedList;
import java.util.List;

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

public class InvalidTypeOperandsChecker extends ASTVisitor {

	protected List<Expression> operandsList;
	private IdentifiersTypeMatcher typeMatcher;

	public InvalidTypeOperandsChecker() {
		this.operandsList = new LinkedList<>();
		this.typeMatcher=new IdentifiersTypeMatcher();
	}

	public List<Expression> check(ASTNode root) {
		this.typeMatcher.match(root);
		root.accept(this);
		return this.operandsList;
	}

	public void visit(Add add)  {
		if(! add.areOperandsTypeValid(typeMatcher))
			this.recordError(add);
	}

	public void visit(Div div)  {
		if(! div.areOperandsTypeValid(typeMatcher))
			this.recordError(div);
	}

	public void visit(Mul mul)  {
		if(! mul.areOperandsTypeValid(typeMatcher))
			this.recordError(mul);
	}

	public void visit(Sub sub)  {
		if(! sub.areOperandsTypeValid(typeMatcher))
			this.recordError(sub);
	}

	public void visit(And and)  {
		if(! and.areOperandsTypeValid(typeMatcher))
			this.recordError(and);
	}

	public void visit(Or or)  {
		if(! or.areOperandsTypeValid(typeMatcher))
			this.recordError(or);
	}

	public void visit(Eq eq)  {
		if(! eq.areOperandsTypeValid(typeMatcher))
			this.recordError(eq);
	}

	public void visit(GEq gEq)  {
		if(! gEq.areOperandsTypeValid(typeMatcher))
			this.recordError(gEq);
	}

	public void visit(GT gt)  {
		if(! gt.areOperandsTypeValid(typeMatcher))
			this.recordError(gt);
	}
	
	public void visit(LEq lEq)  {
		if(! lEq.areOperandsTypeValid(typeMatcher))
			this.recordError(lEq);
	}

	public void visit(LT lt) {
		if(! lt.areOperandsTypeValid(typeMatcher))
			this.recordError(lt);
	}

	public void visit(NEq nEq) {
		if(! nEq.areOperandsTypeValid(typeMatcher))
			this.recordError(nEq);
	}

	public void visit(Neg neg) {
		if(! neg.areOperandsTypeValid(typeMatcher))
			this.recordError(neg);
	}

	public void visit(Not not) {
		if(! not.areOperandsTypeValid(typeMatcher))
			this.recordError(not);
	}

	public void visit(Pos pos) {
		if(! pos.areOperandsTypeValid(typeMatcher))
			this.recordError(pos);
	}
	
	private boolean recordError(Expression exp) {
		return this.operandsList.add(exp);
	}
}
