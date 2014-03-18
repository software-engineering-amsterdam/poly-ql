package test.nl.uva;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.element.Form;
import main.nl.uva.parser.element.error.ValidationError;
import main.nl.uva.parser.element.expression.And;
import main.nl.uva.parser.element.expression.Not;
import main.nl.uva.parser.element.expression.Variable;
import main.nl.uva.parser.element.expression.atom.VariableAtom;
import main.nl.uva.parser.element.statement.Declaration;
import main.nl.uva.parser.element.statement.IF;
import main.nl.uva.parser.element.statement.IfElse;
import main.nl.uva.parser.element.statement.Statement;
import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.parser.element.type.Money;
import main.nl.uva.parser.validation.Scope;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidationTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidVariableValidation() {

        Variable v1 = new Variable(new Bool(), "testVar");
        Variable v2 = new Variable(new Bool(), "testVar", new VariableAtom("testVar"));

        Declaration decStatement1 = new Declaration(v1, "declares variable");
        Declaration decStatement2 = new Declaration(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement1);
        children.add(decStatement2);
        Form form = new Form("testForm", children);

        Assert.assertTrue("Valid statement was marked invalid", !form.validate(new Scope()).hasErrors());
    }

    @Test
    public void testInvalidVariableValidation() {

        Variable v1 = new Variable(new Bool(), "testVar");
        Variable v2 = new Variable(new Bool(), "testVar", new VariableAtom("testVar"));

        Declaration decStatement1 = new Declaration(v1, "declares variable");
        Declaration decStatement2 = new Declaration(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement2);
        children.add(decStatement1);
        Form form = new Form("testForm", children);

        Assert.assertTrue("Invalid statement was not marked invalid", form.validate(new Scope()).hasErrors());
    }

    @Test
    public void testValidExpression() {

        Variable v1 = new Variable(new Bool(), "testBoolean");
        Variable v2 = new Variable(new Bool(), "testBoolean2");

        And andExpression = new And(v1, v2);

        Assert.assertFalse("Valid statement was marked invalid", andExpression.validate(new Scope()).hasErrors());
    }

    @Test
    public void testInvalidExpression() {

        Variable v1 = new Variable(new Bool(), "testBoolean");
        Variable v2 = new Variable(new Money(), "testMoney");

        And andExpression = new And(v1, v2);

        Assert.assertTrue("Invalid statement was not marked invalid", andExpression.validate(new Scope()).hasErrors());
    }

    @Test
    public void testIfElseValid() {

        Variable v1 = new Variable(new Bool(), "testVar");
        List<Statement> children = new ArrayList<Statement>();
        children.add(new Declaration(v1, "declares variable"));

        Variable v2 = new Variable(new Bool(), "testVarUser", new VariableAtom("testVar"));
        Variable v3 = new Variable(new Bool(), "testBoolean");
        Variable v4 = new Variable(new Money(), "testMoney");

        Declaration decStatement1 = new Declaration(v3, "declares variable");
        Declaration decStatement2 = new Declaration(v4, "uses variabe");

        List<Statement> ifBlock = new ArrayList<>();
        ifBlock.add(decStatement1);

        List<Statement> elseBlock = new ArrayList<>();
        elseBlock.add(decStatement2);

        IF ifStatement = new IF(v2, ifBlock);
        IF elseStatement = new IF(new Not(v2), elseBlock);

        IfElse ifElse = new IfElse(ifStatement, elseStatement);

        children.add(ifElse);
        Form form = new Form("testForm", children);

        Assert.assertFalse("Valid statement was marked invalid", form.validate(new Scope()).hasErrors());
    }

    @Test
    public void testIfElseInvalid() {
        List<Statement> children = new ArrayList<Statement>();

        Variable v2 = new Variable(new Bool(), "testVarUser", new VariableAtom("testVar"));
        Variable v3 = new Variable(new Bool(), "testBoolean");
        Variable v4 = new Variable(new Money(), "testMoney");

        Declaration decStatement1 = new Declaration(v3, "declares variable");
        Declaration decStatement2 = new Declaration(v4, "uses variabe");

        List<Statement> ifBlock = new ArrayList<>();
        ifBlock.add(decStatement1);

        List<Statement> elseBlock = new ArrayList<>();
        elseBlock.add(decStatement2);

        IF ifStatement = new IF(v2, ifBlock);
        IF elseStatement = new IF(new Not(v2), elseBlock);

        IfElse ifElse = new IfElse(ifStatement, elseStatement);

        children.add(ifElse);
        Form form = new Form("testForm", children);

        Assert.assertTrue("Invalid statement was not marked invalid", form.validate(new Scope()).hasErrors());
    }

    public static void printErrors(final List<ValidationError> errors) {
        for (ValidationError error : errors) {
            System.out.println(error);
        }
    }
}
