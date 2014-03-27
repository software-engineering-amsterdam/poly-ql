package test.nl.uva;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Addition;
import main.nl.uva.parser.expression.And;
import main.nl.uva.parser.expression.Division;
import main.nl.uva.parser.expression.Equal;
import main.nl.uva.parser.expression.Multiplication;
import main.nl.uva.parser.expression.Or;
import main.nl.uva.parser.expression.Substraction;
import main.nl.uva.parser.expression.Variable;
import main.nl.uva.parser.expression.unary.BoolAtom;
import main.nl.uva.parser.expression.unary.MoneyAtom;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Value;

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
        Addition expression = new Addition(new MoneyAtom(new Money(3)), new MoneyAtom(new Money(5)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(8, value.getValue(), 0.0001);
    }

    @Test
    public void testSubstraction() {
        Substraction expression = new Substraction(new MoneyAtom(new Money(3)), new MoneyAtom(new Money(5)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(-2, value.getValue(), 0.0001);
    }

    @Test
    public void testMultiplication() {
        Multiplication expression = new Multiplication(new MoneyAtom(new Money(3)), new MoneyAtom(new Money(5)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(15, value.getValue(), 0.0001);
    }

    @Test
    public void testDivision() {
        Division expression = new Division(new MoneyAtom(new Money(3)), new MoneyAtom(new Money(5)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        Money value = (Money) expression.getValue();
        Assert.assertEquals(3.0 / 5.0, value.getValue(), 0.0001);
    }

    @Test
    public void testAnd() {
        And expression = new And(new BoolAtom(new Bool(true)), new BoolAtom(new Bool(false)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        Bool value = (Bool) expression.getValue();
        Assert.assertFalse(value.getValue());
    }

    @Test
    public void testOr() {
        Or expression = new Or(new BoolAtom(new Bool(true)), new BoolAtom(new Bool(false)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        Bool value = (Bool) expression.getValue();
        Assert.assertTrue(value.getValue());
    }

    @Test
    public void testComparrison() {
        Equal expression = new Equal(new BoolAtom(new Bool(true)), new BoolAtom(new Bool(false)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        Bool value = (Bool) expression.getValue();
        Assert.assertFalse(value.getValue());

        expression = new Equal(new MoneyAtom(new Money(3)), new MoneyAtom(new Money(3)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        value = (Bool) expression.getValue();
        Assert.assertTrue(value.getValue());

        expression = new Equal(new MoneyAtom(new Money(3)), new MoneyAtom(new Money(4)), Line.NO_LINE_NUMBER);
        Assert.assertFalse(expression.validateAndCalculate(new Scope()).hasErrors());

        value = (Bool) expression.getValue();
        Assert.assertFalse(value.getValue());
    }

    @Test
    public void testVariable() {
        Variable variable = new Variable(Value.Type.MONEY, "payment", new Multiplication(new MoneyAtom(new Money(3)), new MoneyAtom(
                new Money(5)), Line.NO_LINE_NUMBER), Line.NO_LINE_NUMBER);
        Assert.assertEquals(variable.getName(), "payment");
        variable.validateAndCalculate(new Scope());
        Assert.assertTrue(variable.getValue().isTypeOf(Value.Type.MONEY));
    }
}
