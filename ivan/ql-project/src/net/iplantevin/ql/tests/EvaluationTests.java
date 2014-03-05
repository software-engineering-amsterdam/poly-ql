package net.iplantevin.ql.tests;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.operators.Add;
import net.iplantevin.ql.ast.expressions.operators.And;
import net.iplantevin.ql.ast.expressions.operators.Div;
import net.iplantevin.ql.ast.expressions.operators.GEQ;
import net.iplantevin.ql.ast.expressions.operators.Mul;
import net.iplantevin.ql.ast.expressions.operators.Neg;
import net.iplantevin.ql.ast.expressions.operators.Pos;
import net.iplantevin.ql.ast.expressions.operators.Sub;
import net.iplantevin.ql.evaluation.BoolVal;
import net.iplantevin.ql.evaluation.EvaluationVisitor;
import net.iplantevin.ql.evaluation.IntVal;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.evaluation.ValueStore;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ivan
 */
public class EvaluationTests {
    private final LineInfo lineInfo = new LineInfo(0, 0);
    private final ValueStore values = new ValueStore();
    private final EvaluationVisitor evaluator = new EvaluationVisitor(values);

    // Expressions/Values for reuse
    private final Int int10 = new Int(10, lineInfo);
    private final Int int5 = new Int(5, lineInfo);
    private final Int int4 = new Int(4, lineInfo);
    private final Bool trueBool = new Bool(true, lineInfo);
    private final Bool falseBool = new Bool(false, lineInfo);
    private final BoolVal trueVal = new BoolVal(true);
    private final BoolVal falseVal = new BoolVal(false);

    @Test
    public void testIntVal() {
        IntVal int5Val = new IntVal(5);
        Value actual = evaluator.evaluate(int5);
        Assert.assertEquals(int5Val, actual);
    }

    @Test
    public void testAddition() {
        Add addInts = new Add(int5, int4, lineInfo);
        IntVal expected = new IntVal(9);
        Value actualVal = evaluator.evaluate(addInts);
        Assert.assertEquals(expected, actualVal);
    }

    @Test
    public void testSubtraction() {
        Sub subInts = new Sub(int5, int4, lineInfo);
        IntVal expected = new IntVal(1);
        Value actual = evaluator.evaluate(subInts);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultiplication() {
        Mul mulInts = new Mul(int5, int4, lineInfo);
        IntVal expected = new IntVal(20);
        Value actual = evaluator.evaluate(mulInts);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDivision() {
        Div divInts = new Div(int10, int5, lineInfo);
        IntVal expected = new IntVal(2);
        Value actual = evaluator.evaluate(divInts);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIntDivision() {
        Div divInts = new Div(int10, int4, lineInfo);
        IntVal expected = new IntVal(2);
        Value actual = evaluator.evaluate(divInts);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPositive() {
        Pos posInt = new Pos(int5, lineInfo);
        IntVal expected = new IntVal(5);
        Value actual = evaluator.evaluate(posInt);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegative() {
        Neg negInt = new Neg(int5, lineInfo);
        IntVal expected = new IntVal(-5);
        Value actual = evaluator.evaluate(negInt);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAnd1() {
        And and = new And(trueBool, trueBool, lineInfo);
        Value actual = evaluator.evaluate(and);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testAnd2() {
        And and = new And(trueBool, falseBool, lineInfo);
        Value actual = evaluator.evaluate(and);
        Assert.assertEquals(falseVal, actual);
    }

    @Test
    public void testGreaterOrEqual1() {
        GEQ geqInts = new GEQ(int5, int4, lineInfo);
        Value actual = evaluator.evaluate(geqInts);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testGreaterOrEqual2() {
        GEQ geqInts = new GEQ(int5, int5, lineInfo);
        Value actual = evaluator.evaluate(geqInts);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testGreaterOrEqual3() {
        GEQ geqInts = new GEQ(int4, int5, lineInfo);
        Value actual = evaluator.evaluate(geqInts);
        Assert.assertEquals(falseVal, actual);
    }
}
