package net.iplantevin.ql.tests;

import net.iplantevin.ql.ast.LineInfo;
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
import net.iplantevin.ql.ast.expressions.operators.Neg;
import net.iplantevin.ql.ast.expressions.operators.Not;
import net.iplantevin.ql.ast.expressions.operators.Or;
import net.iplantevin.ql.ast.expressions.operators.Pos;
import net.iplantevin.ql.ast.expressions.operators.Sub;
import net.iplantevin.ql.evaluation.BoolVal;
import net.iplantevin.ql.evaluation.EvaluationVisitor;
import net.iplantevin.ql.evaluation.IntVal;
import net.iplantevin.ql.evaluation.StrVal;
import net.iplantevin.ql.evaluation.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Ivan
 */
public class EvaluationTests {
    private final LineInfo lineInfo = new LineInfo(0, 0);
    private EvaluationVisitor evaluator;

    // Expressions/Values for reuse
    private final Int int10 = new Int(10, lineInfo);
    private final Int int5 = new Int(5, lineInfo);
    private final Int int4 = new Int(4, lineInfo);
    private final Str str1 = new Str("\"placeholder\"", lineInfo);
    private final ID id1 = new ID("ident1", lineInfo);
    private final ID id2 = new ID("ident2", lineInfo);
    private final Bool trueBool = new Bool(true, lineInfo);
    private final Bool falseBool = new Bool(false, lineInfo);
    private final BoolVal trueVal = new BoolVal(true);
    private final BoolVal falseVal = new BoolVal(false);

    @Before
    public void setUp() {
        evaluator = new EvaluationVisitor();
    }

    @Test
    public void testIntVal() {
        IntVal expected = new IntVal(5);
        Value actual = evaluator.evaluate(int5);
        Assert.assertEquals(expected, actual);
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
    public void testDivideByZero() {
        Div divInts = new Div(int5, new Int(0, lineInfo), lineInfo);
        Value actual = evaluator.evaluate(divInts);
        Assert.assertTrue(actual.isUndefined());
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
    public void testNegative1() {
        Neg negInt = new Neg(int5, lineInfo);
        IntVal expected = new IntVal(-5);
        Value actual = evaluator.evaluate(negInt);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegative2() {
        Neg negNegInt = new Neg(new Neg(int5, lineInfo), lineInfo);
        IntVal expected = new IntVal(5);
        Value actual = evaluator.evaluate(negNegInt);
        Assert.assertEquals(expected, actual);
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

    @Test
    public void testGreaterThan1() {
        GT gtInts = new GT(int5, int4, lineInfo);
        Value actual = evaluator.evaluate(gtInts);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testGreaterThan2() {
        GT gtInts = new GT(int5, int5, lineInfo);
        Value actual = evaluator.evaluate(gtInts);
        Assert.assertEquals(falseVal, actual);
    }

    @Test
    public void testGreaterThan3() {
        GT gtInts = new GT(int4, int5, lineInfo);
        Value actual = evaluator.evaluate(gtInts);
        Assert.assertEquals(falseVal, actual);
    }

    @Test
    public void testLessOrEqual1() {
        LEQ leqInts = new LEQ(int4, int5, lineInfo);
        Value actual = evaluator.evaluate(leqInts);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testLessOrEqual2() {
        LEQ leqInts = new LEQ(int5, int5, lineInfo);
        Value actual = evaluator.evaluate(leqInts);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testLessOrEqual3() {
        LEQ leqInts = new LEQ(int5, int4, lineInfo);
        Value actual = evaluator.evaluate(leqInts);
        Assert.assertEquals(falseVal, actual);
    }

    @Test
    public void testLessThan1() {
        LT ltInts = new LT(int4, int5, lineInfo);
        Value actual = evaluator.evaluate(ltInts);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testLessThan2() {
        LT ltInts = new LT(int5, int5, lineInfo);
        Value actual = evaluator.evaluate(ltInts);
        Assert.assertEquals(falseVal, actual);
    }

    @Test
    public void testLessThan3() {
        LT ltInts = new LT(int5, int4, lineInfo);
        Value actual = evaluator.evaluate(ltInts);
        Assert.assertEquals(falseVal, actual);
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
    public void testOr1() {
        Or or = new Or(falseBool, falseBool, lineInfo);
        Value actual = evaluator.evaluate(or);
        Assert.assertEquals(falseVal, actual);
    }

    @Test
    public void testOr2() {
        Or or = new Or(falseBool, trueBool, lineInfo);
        Value actual = evaluator.evaluate(or);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testNot1() {
        Not not = new Not(falseBool, lineInfo);
        Value actual = evaluator.evaluate(not);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testNot2() {
        Not not = new Not(trueBool, lineInfo);
        Value actual = evaluator.evaluate(not);
        Assert.assertEquals(falseVal, actual);
    }


    /////////////////////////////////////////////
    // Below, some invalid operations that should
    // lead to UndefinedVal
    /////////////////////////////////////////////
    // First a verification of |isUndefined|
    @Test
    public void testUndefined0() {
        Add add = new Add(int5, int4, lineInfo);
        Value actual = evaluator.evaluate(add);
        Assert.assertFalse(actual.isUndefined());
    }

    @Test
    public void testUndefined1() {
        Add add = new Add(int5, trueBool, lineInfo);
        Value actual = evaluator.evaluate(add);
        Assert.assertTrue(actual.isUndefined());
    }

    @Test
    public void testUndefined2() {
        Mul mul = new Mul(int5, str1, lineInfo);
        Value actual = evaluator.evaluate(mul);
        Assert.assertTrue(actual.isUndefined());
    }

    @Test
    public void testUndefined3() {
        And and = new And(int5, trueBool, lineInfo);
        Value actual = evaluator.evaluate(and);
        Assert.assertTrue(actual.isUndefined());
    }

    @Test
    public void testUndefined4() {
        Or or = new Or(trueBool, str1, lineInfo);
        Value actual = evaluator.evaluate(or);
        Assert.assertTrue(actual.isUndefined());
    }

    @Test
    public void testUndefined5() {
        GT gt = new GT(int5, trueBool, lineInfo);
        Value actual = evaluator.evaluate(gt);
        Assert.assertTrue(actual.isUndefined());
    }

    @Test
    public void testUndefined6() {
        LEQ leq = new LEQ(str1, int4, lineInfo);
        Value actual = evaluator.evaluate(leq);
        Assert.assertTrue(actual.isUndefined());
    }

    /////////////////////////////////////////////
    // Below, some tests with the ValueStore.
    /////////////////////////////////////////////
    @Test
    public void testId1() {
        evaluator.storeValue(id1.getName(), new IntVal(4));
        Add add = new Add(id1, int5, lineInfo);
        Value actual = evaluator.evaluate(add);
        Assert.assertEquals(new IntVal(9), actual);
    }

    @Test
    public void testId2() {
        evaluator.storeValue(id1.getName(), trueVal);
        And and = new And(id1, trueBool, lineInfo);
        Value actual = evaluator.evaluate(and);
        Assert.assertEquals(trueVal, actual);
    }

    @Test
    public void testId3() {
        evaluator.storeValue(id1.getName(), new StrVal("placeholder"));
        EQ eq = new EQ(id1, str1, lineInfo);
        Value actual = evaluator.evaluate(eq);
        Assert.assertEquals(trueVal, actual);
    }

    //////////////////////////////////////////////////////////////////////
    // Tests to verify that an identifier with an undefined value results
    // in an UndefinedVal or a false BoolVal.
    //////////////////////////////////////////////////////////////////////
    @Test
    public void testUndefinedId1() {
        evaluator.storeValue(id1.getName(), new StrVal("placeholder"));
        EQ eq = new EQ(id1, id2, lineInfo);
        Value actual = evaluator.evaluate(eq);
        Assert.assertEquals(falseVal, actual);
    }

    @Test
    public void testUndefinedId2() {
        evaluator.storeValue(id1.getName(), new IntVal(5));
        Add add = new Add(id1, id2, lineInfo);
        Value actual = evaluator.evaluate(add);
        Assert.assertTrue(actual.isUndefined());
    }

    @Test
    public void testUndefinedId3() {
        evaluator.storeValue(id1.getName(), new IntVal(5));
        LT lt = new LT(id1, id2, lineInfo);
        Value actual = evaluator.evaluate(lt);
        Assert.assertTrue(actual.isUndefined());
    }
}
