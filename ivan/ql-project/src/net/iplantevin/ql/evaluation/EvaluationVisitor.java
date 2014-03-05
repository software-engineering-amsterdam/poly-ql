package net.iplantevin.ql.evaluation;

import net.iplantevin.ql.ast.expressions.Expression;
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
import net.iplantevin.ql.ast.visitors.IASTVisitor;

import java.util.HashMap;
import java.util.Map;

/**
 * Visitor that takes an expression and returns the appropriate value.
 *
 * @author Ivan
 */
public class EvaluationVisitor implements IASTVisitor<Value> {
    private final ValueStore values;

    private EvaluationVisitor() {
        values = new ValueStore();
    }

    public static Value evaluateExpression(Expression expression) {
        EvaluationVisitor evaluator = new EvaluationVisitor();
        return expression.accept(evaluator);
    }

    /////////////////////////////////////////////
    // Visitor methods
    /////////////////////////////////////////////
    @Override
    public Value visit(FormCollection formCollection) {
        return null;
    }

    @Override
    public Value visit(Form form) {
        return null;
    }

    @Override
    public Value visit(Block block) {
        return null;
    }

    @Override
    public Value visit(Computation computation) {
        return null;
    }

    @Override
    public Value visit(If ifStat) {
        return null;
    }

    @Override
    public Value visit(IfElse ifElse) {
        return null;
    }

    @Override
    public Value visit(Question question) {
        return null;
    }

    @Override
    public Value visit(Par par) {
        return null;
    }

    @Override
    public Value visit(Add add) {
        return null;
    }

    @Override
    public Value visit(And and) {
        return null;
    }

    @Override
    public Value visit(Div div) {
        return null;
    }

    @Override
    public Value visit(EQ eq) {
        return null;
    }

    @Override
    public Value visit(GEQ geq) {
        return null;
    }

    @Override
    public Value visit(GT gt) {
        return null;
    }

    @Override
    public Value visit(LEQ leq) {
        return null;
    }

    @Override
    public Value visit(LT lt) {
        return null;
    }

    @Override
    public Value visit(Mul mul) {
        return null;
    }

    @Override
    public Value visit(Neg neg) {
        return null;
    }

    @Override
    public Value visit(NEQ neq) {
        return null;
    }

    @Override
    public Value visit(Not not) {
        return null;
    }

    @Override
    public Value visit(Or or) {
        return null;
    }

    @Override
    public Value visit(Pos pos) {
        return null;
    }

    @Override
    public Value visit(Sub sub) {
        return null;
    }

    @Override
    public Value visit(Bool bool) {
        return null;
    }

    @Override
    public Value visit(ID id) {
        return null;
    }

    @Override
    public Value visit(Int integer) {
        return null;
    }

    @Override
    public Value visit(Str str) {
        return null;
    }
}
