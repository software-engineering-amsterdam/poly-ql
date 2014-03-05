package net.iplantevin.ql.ast.visitors;

import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.Add;
import net.iplantevin.ql.ast.expressions.operators.And;
import net.iplantevin.ql.ast.expressions.operators.Div;
import net.iplantevin.ql.ast.expressions.operators.EQ;
import net.iplantevin.ql.ast.expressions.operators.GEQ;
import net.iplantevin.ql.ast.expressions.operators.GT;
import net.iplantevin.ql.ast.expressions.operators.LEQ;
import net.iplantevin.ql.ast.expressions.operators.LT;
import net.iplantevin.ql.ast.expressions.operators.Mul;
import net.iplantevin.ql.ast.expressions.operators.NEQ;
import net.iplantevin.ql.ast.expressions.operators.Neg;
import net.iplantevin.ql.ast.expressions.operators.Not;
import net.iplantevin.ql.ast.expressions.operators.Or;
import net.iplantevin.ql.ast.expressions.operators.Pos;
import net.iplantevin.ql.ast.expressions.operators.Sub;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;

/**
 * General interface for visiting the AST. Abstract classes can of course not
 * be visited.
 *
 * @author Ivan
 */
public interface IASTVisitor {
    public void visit(FormCollection formCollection);

    public void visit(Form form);

    // Statements
    public void visit(Block block);

    public void visit(Computation computation);

    public void visit(If ifStat);

    public void visit(IfElse ifElse);

    public void visit(Question question);

    // Parentheses expression
    public void visit(Par par);

    // Operators
    public void visit(Add add);

    public void visit(And and);

    public void visit(Div div);

    public void visit(EQ eq);

    public void visit(GEQ geq);

    public void visit(GT gt);

    public void visit(LEQ leq);

    public void visit(LT lt);

    public void visit(Mul mul);

    public void visit(Neg neg);

    public void visit(NEQ neq);

    public void visit(Not not);

    public void visit(Or or);

    public void visit(Pos pos);

    public void visit(Sub sub);

    // Literals
    public void visit(Bool bool);

    public void visit(ID id);

    public void visit(Int integer);

    public void visit(Str str);
}
