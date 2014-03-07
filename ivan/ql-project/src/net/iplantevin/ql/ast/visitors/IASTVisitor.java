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
public interface IASTVisitor<T> {
    public T visit(FormCollection formCollection);

    public T visit(Form form);

    // Statements
    public T visit(Block block);

    public T visit(Computation computation);

    public T visit(If ifStat);

    public T visit(IfElse ifElse);

    public T visit(Question question);

    // Parentheses expression
    public T visit(Par par);

    // Operators
    public T visit(Add add);

    public T visit(And and);

    public T visit(Div div);

    public T visit(EQ eq);

    public T visit(GEQ geq);

    public T visit(GT gt);

    public T visit(LEQ leq);

    public T visit(LT lt);

    public T visit(Mul mul);

    public T visit(Neg neg);

    public T visit(NEQ neq);

    public T visit(Not not);

    public T visit(Or or);

    public T visit(Pos pos);

    public T visit(Sub sub);

    // Literals
    public T visit(Bool bool);

    public T visit(ID id);

    public T visit(Int integer);

    public T visit(Str str);
}
