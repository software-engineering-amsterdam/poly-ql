package test.nl.uva;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.AndExpression;
import main.nl.uva.parser.elements.expressions.NotExpression;
import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.expressions.atoms.VariableAtom;
import main.nl.uva.parser.elements.statements.DeclarationStatement;
import main.nl.uva.parser.elements.statements.IFStatement;
import main.nl.uva.parser.elements.statements.IfElseStatement;
import main.nl.uva.parser.elements.statements.ParserForm;
import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.validation.Scope;

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

        DeclarationStatement decStatement1 = new DeclarationStatement(v1, "declares variable");
        DeclarationStatement decStatement2 = new DeclarationStatement(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement1);
        children.add(decStatement2);
        ParserForm form = new ParserForm("testForm", children);

        Assert.assertTrue("Valid statement was marked invalid", !form.validate(new Scope()).hasErrors());
    }

    @Test
    public void testInvalidVariableValidation() {

        Variable v1 = new Variable(new Bool(), "testVar");
        Variable v2 = new Variable(new Bool(), "testVar", new VariableAtom("testVar"));

        DeclarationStatement decStatement1 = new DeclarationStatement(v1, "declares variable");
        DeclarationStatement decStatement2 = new DeclarationStatement(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement2);
        children.add(decStatement1);
        ParserForm form = new ParserForm("testForm", children);

        Assert.assertTrue("Invalid statement was not marked invalid", form.validate(new Scope()).hasErrors());
    }

    @Test
    public void testValidExpression() {

        Variable v1 = new Variable(new Bool(), "testBoolean");
        Variable v2 = new Variable(new Bool(), "testBoolean2");

        AndExpression andExpression = new AndExpression(v1, v2);

        Assert.assertFalse("Valid statement was marked invalid", andExpression.validate(new Scope()).hasErrors());
    }

    @Test
    public void testInvalidExpression() {

        Variable v1 = new Variable(new Bool(), "testBoolean");
        Variable v2 = new Variable(new Money(), "testMoney");

        AndExpression andExpression = new AndExpression(v1, v2);

        Assert.assertTrue("Invalid statement was not marked invalid", andExpression.validate(new Scope()).hasErrors());
    }

    @Test
    public void testIfElseValid() {

        Variable v1 = new Variable(new Bool(), "testVar");
        List<Statement> children = new ArrayList<Statement>();
        children.add(new DeclarationStatement(v1, "declares variable"));

        Variable v2 = new Variable(new Bool(), "testVarUser", new VariableAtom("testVar"));
        Variable v3 = new Variable(new Bool(), "testBoolean");
        Variable v4 = new Variable(new Money(), "testMoney");

        DeclarationStatement decStatement1 = new DeclarationStatement(v3, "declares variable");
        DeclarationStatement decStatement2 = new DeclarationStatement(v4, "uses variabe");

        List<Statement> ifBlock = new ArrayList<>();
        ifBlock.add(decStatement1);

        List<Statement> elseBlock = new ArrayList<>();
        elseBlock.add(decStatement2);

        IFStatement ifStatement = new IFStatement(v2, ifBlock);
        IFStatement elseStatement = new IFStatement(new NotExpression(v2), elseBlock);

        IfElseStatement ifElse = new IfElseStatement(ifStatement, elseStatement);

        children.add(ifElse);
        ParserForm form = new ParserForm("testForm", children);

        Assert.assertFalse("Valid statement was marked invalid", form.validate(new Scope()).hasErrors());
    }

    @Test
    public void testIfElseInvalid() {
        List<Statement> children = new ArrayList<Statement>();

        Variable v2 = new Variable(new Bool(), "testVarUser", new VariableAtom("testVar"));
        Variable v3 = new Variable(new Bool(), "testBoolean");
        Variable v4 = new Variable(new Money(), "testMoney");

        DeclarationStatement decStatement1 = new DeclarationStatement(v3, "declares variable");
        DeclarationStatement decStatement2 = new DeclarationStatement(v4, "uses variabe");

        List<Statement> ifBlock = new ArrayList<>();
        ifBlock.add(decStatement1);

        List<Statement> elseBlock = new ArrayList<>();
        elseBlock.add(decStatement2);

        IFStatement ifStatement = new IFStatement(v2, ifBlock);
        IFStatement elseStatement = new IFStatement(new NotExpression(v2), elseBlock);

        IfElseStatement ifElse = new IfElseStatement(ifStatement, elseStatement);

        children.add(ifElse);
        ParserForm form = new ParserForm("testForm", children);

        Assert.assertTrue("Invalid statement was not marked invalid", form.validate(new Scope()).hasErrors());
    }

    public static void printErrors(final List<ValidationError> errors) {
        for (ValidationError error : errors) {
            System.out.println(error);
        }
    }
}
