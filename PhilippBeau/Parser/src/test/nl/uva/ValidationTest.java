package test.nl.uva;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.Form;
import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.And;
import main.nl.uva.parser.expression.Variable;
import main.nl.uva.parser.expression.unary.VariableAtom;
import main.nl.uva.parser.statement.Declaration;
import main.nl.uva.parser.statement.IfThenElse;
import main.nl.uva.parser.statement.Statement;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.type.Value;

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

        Variable v1 = new Variable(Value.Type.BOOLEAN, "testVar", Line.NO_LINE_NUMBER);
        Variable v2 = new Variable(Value.Type.BOOLEAN, "usesTestVar", new VariableAtom("testVar", Line.NO_LINE_NUMBER), Line.NO_LINE_NUMBER);

        Declaration decStatement1 = new Declaration(v1, "declares variable");
        Declaration decStatement2 = new Declaration(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement1);
        children.add(decStatement2);
        Form form = new Form("testForm", children, Line.NO_LINE_NUMBER);

        form.validateAndCalculate(new Scope()).printErrors();
        Assert.assertTrue("Valid statement was marked invalid", !form.validateAndCalculate(new Scope()).hasErrors());
    }

    @Test
    public void testInvalidVariableValidation() {

        Variable v1 = new Variable(Value.Type.BOOLEAN, "testVar", Line.NO_LINE_NUMBER);
        Variable v2 = new Variable(Value.Type.BOOLEAN, "testVar", new VariableAtom("testVar", Line.NO_LINE_NUMBER), Line.NO_LINE_NUMBER);

        Declaration decStatement1 = new Declaration(v1, "declares variable");
        Declaration decStatement2 = new Declaration(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement2);
        children.add(decStatement1);
        Form form = new Form("testForm", children, Line.NO_LINE_NUMBER);

        Assert.assertTrue("Invalid statement was not marked invalid", form.validateAndCalculate(new Scope()).hasErrors());
    }

    @Test
    public void testValidExpression() {

        Variable v1 = new Variable(Value.Type.BOOLEAN, "testBoolean", Line.NO_LINE_NUMBER);
        Variable v2 = new Variable(Value.Type.BOOLEAN, "testBoolean2", Line.NO_LINE_NUMBER);

        And andExpression = new And(v1, v2, Line.NO_LINE_NUMBER);

        Assert.assertFalse("Valid statement was marked invalid", andExpression.validateAndCalculate(new Scope()).hasErrors());
    }

    @Test
    public void testInvalidExpression() {

        Variable v1 = new Variable(Value.Type.BOOLEAN, "testBoolean", Line.NO_LINE_NUMBER);
        Variable v2 = new Variable(Value.Type.MONEY, "testMoney", Line.NO_LINE_NUMBER);

        And andExpression = new And(v1, v2, Line.NO_LINE_NUMBER);

        Assert.assertTrue("Invalid statement was not marked invalid", andExpression.validateAndCalculate(new Scope()).hasErrors());
    }

    @Test
    public void testIfElseValid() {

        Variable v1 = new Variable(Value.Type.BOOLEAN, "testVar", Line.NO_LINE_NUMBER);
        List<Statement> children = new ArrayList<Statement>();
        children.add(new Declaration(v1, "declares variable"));

        Variable v2 = new Variable(Value.Type.BOOLEAN, "testVarUser", new VariableAtom("testVar", Line.NO_LINE_NUMBER), Line.NO_LINE_NUMBER);
        Variable v3 = new Variable(Value.Type.BOOLEAN, "testBoolean", Line.NO_LINE_NUMBER);
        Variable v4 = new Variable(Value.Type.MONEY, "testMoney", Line.NO_LINE_NUMBER);

        Declaration decStatement1 = new Declaration(v3, "declares variable");
        Declaration decStatement2 = new Declaration(v4, "uses variabe");

        List<Statement> ifBlock = new ArrayList<>();
        ifBlock.add(decStatement1);

        List<Statement> elseBlock = new ArrayList<>();
        elseBlock.add(decStatement2);

        IfThenElse ifElse = new IfThenElse(v2, ifBlock, elseBlock, Line.NO_LINE_NUMBER);

        children.add(ifElse);
        Form form = new Form("testForm", children, Line.NO_LINE_NUMBER);

        Assert.assertFalse("Valid statement was marked invalid", form.validateAndCalculate(new Scope()).hasErrors());
    }

    @Test
    public void testIfElseInvalid() {
        List<Statement> children = new ArrayList<Statement>();

        Variable v2 = new Variable(Value.Type.BOOLEAN, "testVarUser", new VariableAtom("testVar", Line.NO_LINE_NUMBER), Line.NO_LINE_NUMBER);
        Variable v3 = new Variable(Value.Type.BOOLEAN, "testBoolean", Line.NO_LINE_NUMBER);
        Variable v4 = new Variable(Value.Type.MONEY, "testMoney", Line.NO_LINE_NUMBER);

        Declaration decStatement1 = new Declaration(v3, "declares variable");
        Declaration decStatement2 = new Declaration(v4, "uses variabe");

        List<Statement> ifBlock = new ArrayList<>();
        ifBlock.add(decStatement1);

        List<Statement> elseBlock = new ArrayList<>();
        elseBlock.add(decStatement2);

        IfThenElse ifElse = new IfThenElse(v2, ifBlock, elseBlock, Line.NO_LINE_NUMBER);

        children.add(ifElse);
        Form form = new Form("testForm", children, Line.NO_LINE_NUMBER);

        Assert.assertTrue("Invalid statement was not marked invalid", form.validateAndCalculate(new Scope()).hasErrors());
    }
}
