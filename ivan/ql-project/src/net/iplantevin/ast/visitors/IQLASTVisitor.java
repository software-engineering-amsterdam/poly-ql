package net.iplantevin.ast.visitors;

import net.iplantevin.ast.expressions.Par;
import net.iplantevin.ast.expressions.literals.Bool;
import net.iplantevin.ast.expressions.literals.ID;
import net.iplantevin.ast.expressions.literals.Int;
import net.iplantevin.ast.expressions.literals.Str;
import net.iplantevin.ast.expressions.operators.*;
import net.iplantevin.ast.form.Form;
import net.iplantevin.ast.form.FormCollection;
import net.iplantevin.ast.statements.*;

/**
 * @author Ivan
 *         General interface for visiting the AST. Abstract classes can of course not
 *         be visited.
 */
public interface IQLASTVisitor {
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
