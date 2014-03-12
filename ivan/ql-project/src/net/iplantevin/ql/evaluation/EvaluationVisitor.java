package net.iplantevin.ql.evaluation;

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

import java.util.HashMap;
import java.util.Map;

/**
 * Visitor that takes an expression and returns the appropriate value.
 *
 * @author Ivan
 */
public class EvaluationVisitor implements IExpressionVisitor<Value> {
    private final Map<String, Value> values;

    public EvaluationVisitor() {
        values = new HashMap<String, Value>();
    }

    public void storeValue(String identifier, Value value) {
        values.put(identifier, value);
    }

    public Value getValue(String identifier) {
        if (values.containsKey(identifier)) {
            return values.get(identifier);
        } else {
            return new UndefinedVal();
        }
    }

    public Value evaluate(Expression expression) {
        try {
            return expression.accept(this);
        } catch (ArithmeticException e) {
            return new UndefinedVal();
        } catch (Exception e) {
            return new UndefinedVal();
        }
    }

    private Value leftValue(Binary expression) {
        return expression.getLeftHS().accept(this);
    }

    private Value rightValue(Binary expression) {
        return expression.getRightHS().accept(this);
    }

    private Value unaryValue(Unary expression) {
        return expression.getExpression().accept(this);
    }

    /////////////////////////////////////////////
    // Expression visitor methods
    /////////////////////////////////////////////
    @Override
    public Value visit(Par par) {
        return par.getExpression().accept(this);
    }

    @Override
    public Value visit(Add add) {
        return leftValue(add).add(rightValue(add));
    }

    @Override
    public Value visit(And and) {
        return leftValue(and).and(rightValue(and));
    }

    @Override
    public Value visit(Div div) {
        return leftValue(div).div(rightValue(div));
    }

    @Override
    public Value visit(EQ eq) {
        return leftValue(eq).equal(rightValue(eq));
    }

    @Override
    public Value visit(GEQ geq) {
        return leftValue(geq).geq(rightValue(geq));
    }

    @Override
    public Value visit(GT gt) {
        return leftValue(gt).gt(rightValue(gt));
    }

    @Override
    public Value visit(LEQ leq) {
        return leftValue(leq).leq(rightValue(leq));
    }

    @Override
    public Value visit(LT lt) {
        return leftValue(lt).lt(rightValue(lt));
    }

    @Override
    public Value visit(Mul mul) {
        return leftValue(mul).mul(rightValue(mul));
    }

    @Override
    public Value visit(Neg neg) {
        return unaryValue(neg).neg();
    }

    @Override
    public Value visit(NEQ neq) {
        return leftValue(neq).notEqual(rightValue(neq));
    }

    @Override
    public Value visit(Not not) {
        return unaryValue(not).not();
    }

    @Override
    public Value visit(Or or) {
        return leftValue(or).or(rightValue(or));
    }

    @Override
    public Value visit(Pos pos) {
        return unaryValue(pos).pos();
    }

    @Override
    public Value visit(Sub sub) {
        return leftValue(sub).sub(rightValue(sub));
    }

    @Override
    public Value visit(Bool bool) {
        return new BoolVal(bool.getValue());
    }

    @Override
    public Value visit(ID id) {
        return getValue(id.getName());
    }

    @Override
    public Value visit(Int integer) {
        return new IntVal(integer.getValue());
    }

    @Override
    public Value visit(Str str) {
        return new StrVal(str.getText());
    }
}
