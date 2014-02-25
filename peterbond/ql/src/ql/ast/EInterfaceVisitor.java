package ql.ast;

import ql.ast.operators.*;
import ql.ast.statements.*;
import ql.ast.misc.*;

public interface EInterfaceVisitor {
	public void visit(Questionnaire questionnaire);
	public void visit(ParOp parOp);
	public void visit(AddOp addOp);
	public void visit(AndOp andOp);
	public void visit(DivOp divOp);
	public void visit(EqOp eqOp);
	public void visit(GtEqOp gtEqOp);
	public void visit(GtOp gtOp);
	public void visit(LtEqOp ltEqOp);
	public void visit(LtOp ltOp);
	public void visit(ModOp modOp);
	public void visit(MulOp mulOp);
	public void visit(NegOp negOp);
	public void visit(OrOp orOp);
	public void visit(SubOp subOp);
	public void visit(IfElseStat ifElseStat);
	public void visit(IfStat ifStat);
	public void visit(QitExprStat qitExprStat);
	public void visit(QitStat qitStat);
}
