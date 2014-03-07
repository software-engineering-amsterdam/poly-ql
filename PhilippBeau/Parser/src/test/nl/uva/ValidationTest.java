package test.nl.uva;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.expressions.atoms.VariableAtom;
import main.nl.uva.parser.elements.statements.DeclarationStatement;
import main.nl.uva.parser.elements.statements.ParserForm;
import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.parser.elements.type.Type;

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

        Variable v1 = new Variable(Type.Of.BOOLEAN, "testVar");
        Variable v2 = new Variable(Type.Of.BOOLEAN, "testVar", new VariableAtom("testVar"));

        DeclarationStatement decStatement1 = new DeclarationStatement(v1, "declares variable");
        DeclarationStatement decStatement2 = new DeclarationStatement(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement1);
        children.add(decStatement2);
        ParserForm form = new ParserForm("testForm", children);

        Assert.assertTrue("This should be valid", form.validate());
    }

    @Test
    public void testInvalidVariableValidation() {

        Variable v1 = new Variable(Type.Of.BOOLEAN, "testVar");
        Variable v2 = new Variable(Type.Of.BOOLEAN, "testVar", new VariableAtom("testVar"));

        DeclarationStatement decStatement1 = new DeclarationStatement(v1, "declares variable");
        DeclarationStatement decStatement2 = new DeclarationStatement(v2, "uses variabe");

        List<Statement> children = new ArrayList<Statement>();
        children.add(decStatement2);
        children.add(decStatement1);
        ParserForm form = new ParserForm("testForm", children);

        Assert.assertFalse("This should not be valid", form.validate());
    }
}
