package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.Add;
import net.iplantevin.ql.ast.expressions.operators.And;
import net.iplantevin.ql.ast.expressions.operators.Binary;
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
import net.iplantevin.ql.ast.expressions.operators.Unary;
import net.iplantevin.ql.ast.visitors.IExpressionVisitor;

import java.util.HashSet;
import java.util.Set;

/**
 * Visitor that gathers all identifiers in an expression and returns them as
 * a set.
 *
 * @author Ivan
 */
public class IdentifierGatherer implements IExpressionVisitor<Void> {
    private final Set<String> identifiers;

    /**
     * IdentifierGatherers are always constructed by a public static method.
     */
    private IdentifierGatherer() {
        identifiers = new HashSet<String>();
    }

    /**
     * Static method that returns a set with all identifiers (Strings) in the
     * given expression.
     *
     * @param expression the expression for which to get all contained identifiers.
     */
    public static Set<String> gather(Expression expression) {
        IdentifierGatherer gatherer = new IdentifierGatherer();
        expression.accept(gatherer);
        return gatherer.getIdentifiers();
    }

    public Set<String> getIdentifiers() {
        return identifiers;
    }

    private void visitBinary(Binary expression) {
        expression.getLeftHS().accept(this);
        expression.getRightHS().accept(this);
    }

    private void visitUnary(Unary expression) {
        expression.getExpression().accept(this);
    }

    @Override
    public Void visit(Par par) {
        par.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(Add add) {
        visitBinary(add);
        return null;
    }

    @Override
    public Void visit(And and) {
        visitBinary(and);
        return null;
    }

    @Override
    public Void visit(Div div) {
        visitBinary(div);
        return null;
    }

    @Override
    public Void visit(EQ eq) {
        visitBinary(eq);
        return null;
    }

    @Override
    public Void visit(GEQ geq) {
        visitBinary(geq);
        return null;
    }

    @Override
    public Void visit(GT gt) {
        visitBinary(gt);
        return null;
    }

    @Override
    public Void visit(LEQ leq) {
        visitBinary(leq);
        return null;
    }

    @Override
    public Void visit(LT lt) {
        visitBinary(lt);
        return null;
    }

    @Override
    public Void visit(Mul mul) {
        visitBinary(mul);
        return null;
    }

    @Override
    public Void visit(Neg neg) {
        visitUnary(neg);
        return null;
    }

    @Override
    public Void visit(NEQ neq) {
        visitBinary(neq);
        return null;
    }

    @Override
    public Void visit(Not not) {
        visitUnary(not);
        return null;
    }

    @Override
    public Void visit(Or or) {
        visitBinary(or);
        return null;
    }

    @Override
    public Void visit(Pos pos) {
        visitUnary(pos);
        return null;
    }

    @Override
    public Void visit(Sub sub) {
        visitBinary(sub);
        return null;
    }

    @Override
    public Void visit(Bool bool) {
        return null;
    }

    /**
     * String identifier is added upon visit of an ID.
     */
    @Override
    public Void visit(ID id) {
        identifiers.add(id.getName());
        return null;
    }

    @Override
    public Void visit(Int integer) {
        return null;
    }

    @Override
    public Void visit(Str str) {
        return null;
    }
}
