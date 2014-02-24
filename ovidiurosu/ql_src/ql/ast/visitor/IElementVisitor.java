package ql.ast.visitor;

import ql.ast.ID;
import ql.ast.Questionnaire;
import ql.ast.expr.ParensExpr;
import ql.ast.literal.BOOLLiteral;
import ql.ast.literal.NUMLiteral;
import ql.ast.literal.STRINGLiteral;
import ql.ast.op.binary.arithmetic.ADD;
import ql.ast.op.binary.arithmetic.DIV;
import ql.ast.op.binary.arithmetic.MUL;
import ql.ast.op.binary.arithmetic.REM;
import ql.ast.op.binary.arithmetic.SUB;
import ql.ast.op.binary.conditional.LA;
import ql.ast.op.binary.conditional.LO;
import ql.ast.op.binary.equality.EQ;
import ql.ast.op.binary.equality.NEQ;
import ql.ast.op.binary.relational.GT;
import ql.ast.op.binary.relational.GTQ;
import ql.ast.op.binary.relational.LT;
import ql.ast.op.binary.relational.LTQ;
import ql.ast.op.unary.NOT;
import ql.ast.op.unary.UM;
import ql.ast.op.unary.UP;
import ql.ast.stat.Assign;
import ql.ast.stat.ComputAssign;
import ql.ast.stat.IfStat;

/**
 * Element Visitor Interface
 * @author orosu
 */
public interface IElementVisitor
{
    public void visit(Questionnaire questionnaire);

    // Statements
    public void visit(IfStat ifStat);
    public void visit(Assign assign);
    public void visit(ComputAssign computAssign);

    public void visit(ID id);
    public void visit(ParensExpr parensExpr);

    // Literals
    public void visit(BOOLLiteral boolLiteral);
    public void visit(NUMLiteral numLiteral);
    public void visit(STRINGLiteral stringLiteral);

    // Arithmetic Binary Operators
    public void visit(ADD add);
    public void visit(DIV div);
    public void visit(MUL mul);
    public void visit(REM rem);
    public void visit(SUB sub);

    // Conditional Binary Operators
    public void visit(LA la);
    public void visit(LO lo);

    // Equality Binary Operators
    public void visit(EQ eq);
    public void visit(NEQ neq);

    // Relational Binary Operators
    public void visit(GT gt);
    public void visit(GTQ gtq);
    public void visit(LT lt);
    public void visit(LTQ ltq);

    // Unary Operators
    public void visit(NOT not);
    public void visit(UM um);
    public void visit(UP up);
}
