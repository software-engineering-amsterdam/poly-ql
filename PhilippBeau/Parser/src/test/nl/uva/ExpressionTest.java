package test.nl.uva;

import main.nl.uva.parser.elements.expressions.AdditionExpression;
import main.nl.uva.parser.elements.expressions.AndExpression;
import main.nl.uva.parser.elements.expressions.ComparrisonExpression;
import main.nl.uva.parser.elements.expressions.DivisionExpression;
import main.nl.uva.parser.elements.expressions.MultiplicationExpression;
import main.nl.uva.parser.elements.expressions.OrExpression;
import main.nl.uva.parser.elements.expressions.SubstractionExpression;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;
import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpressionTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testAddition() {
        AdditionExpression expression = new AdditionExpression(new MoneyAtom("3"), new MoneyAtom("5"));
        Assert.assertTrue(expression.validate().isEmpty());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(8, value.getValue(), 0.0001);
    }

    @Test
    public void testSubstraction() {
        SubstractionExpression expression = new SubstractionExpression(new MoneyAtom("3"), new MoneyAtom("5"));
        Assert.assertTrue(expression.validate().isEmpty());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(-2, value.getValue(), 0.0001);
    }

    @Test
    public void testMultiplication() {
        MultiplicationExpression expression = new MultiplicationExpression(new MoneyAtom("3"), new MoneyAtom("5"));
        Assert.assertTrue(expression.validate().isEmpty());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(15, value.getValue(), 0.0001);
    }

    @Test
    public void testDivision() {
        DivisionExpression expression = new DivisionExpression(new MoneyAtom("3"), new MoneyAtom("5"));
        Assert.assertTrue(expression.validate().isEmpty());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(3.0 / 5.0, value.getValue(), 0.0001);
    }

    @Test
    public void testAnd() {
        AndExpression expression = new AndExpression(new BoolAtom("true"), new BoolAtom("false"));
        Assert.assertTrue(expression.validate().isEmpty());

        Bool value = (Bool) expression.getValue();
        Assert.assertFalse(value.getValue());
    }

    @Test
    public void testOr() {
        OrExpression expression = new OrExpression(new BoolAtom("true"), new BoolAtom("false"));
        Assert.assertTrue(expression.validate().isEmpty());

        Bool value = (Bool) expression.getValue();
        Assert.assertTrue(value.getValue());
    }

    @Test
    public void testComparrison() {
        ComparrisonExpression expression = new ComparrisonExpression(new BoolAtom("true"), new BoolAtom("false"));
        Assert.assertTrue(expression.validate().isEmpty());

        Bool value = (Bool) expression.getValue();
        Assert.assertFalse(value.getValue());

        expression = new ComparrisonExpression(new MoneyAtom("3"), new MoneyAtom("3"));
        Assert.assertTrue(expression.validate().isEmpty());

        value = (Bool) expression.getValue();
        Assert.assertTrue(value.getValue());

        expression = new ComparrisonExpression(new MoneyAtom("3"), new MoneyAtom("4"));
        Assert.assertTrue(expression.validate().isEmpty());

        value = (Bool) expression.getValue();
        Assert.assertFalse(value.getValue());
    }
}
