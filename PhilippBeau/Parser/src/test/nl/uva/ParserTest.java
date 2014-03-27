package test.nl.uva;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import main.nl.uva.g4.FormGrammarLexer;
import main.nl.uva.g4.FormGrammarParser;
import main.nl.uva.parser.Form;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParserTest {

    private static final String QUESTIONAIRE_PATH = "questionaires/test";

    private static final String INVALID_QUESTIONAIRE = QUESTIONAIRE_PATH + "/invalid";

    private static final String VALID_QUESTIONAIRE = QUESTIONAIRE_PATH + "/valid";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @Before
    public void setUp() throws Exception {

    }

    private static Form getFormForFile(final String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));

        FormGrammarLexer lexer = new FormGrammarLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FormGrammarParser parser = new FormGrammarParser(tokens);

        return parser.form().parsedForm;
    }

    @Test
    public void validExample() throws FileNotFoundException, IOException {
        Form form = getFormForFile(VALID_QUESTIONAIRE + "/example.txt");

        ASTValidation validation = form.validate(new Scope());
        validation.printErrors();
        Assert.assertFalse(validation.hasErrors());
    }

    @Test
    public void validIfElse() throws FileNotFoundException, IOException {
        Form form = getFormForFile(VALID_QUESTIONAIRE + "/if_else.txt");

        ASTValidation validation = form.validate(new Scope());
        validation.printErrors();
        Assert.assertFalse(validation.hasErrors());
    }

    @Test
    public void validNestedIf() throws FileNotFoundException, IOException {
        Form form = getFormForFile(VALID_QUESTIONAIRE + "/nested_if.txt");

        ASTValidation validation = form.validate(new Scope());
        validation.printErrors();
        Assert.assertFalse(validation.hasErrors());
    }

    @Test
    public void booleanToMoneyTest() throws FileNotFoundException, IOException {
        Form form = getFormForFile(INVALID_QUESTIONAIRE + "/bool_to_int.txt");

        ASTValidation validation = form.validate(new Scope());
        Assert.assertTrue(validation.hasErrors());

        Assert.assertTrue(("[3 1] Invalid type of \"question1\"").equals(validation.getValidationErrors().get(0).toString()));
    }

    @Test
    public void conditionNotBooleanTest() throws FileNotFoundException, IOException {
        Form form = getFormForFile(INVALID_QUESTIONAIRE + "/condition_not_boolean.txt");

        ASTValidation validation = form.validate(new Scope());
        Assert.assertTrue(validation.hasErrors());

        Assert.assertTrue(("[7 1] Invalid type of \"if ( q2 + q3 )\"").equals(validation.getValidationErrors().get(0).toString()));
    }

    @Test
    public void cyclicDependencyTest() throws FileNotFoundException, IOException {
        Form form = getFormForFile(INVALID_QUESTIONAIRE + "/cyclic_dependency.txt");

        ASTValidation validation = form.validate(new Scope());
        Assert.assertTrue(validation.hasErrors());

        Assert.assertTrue(("[3 38] Variable \"q3\" not found").equals(validation.getValidationErrors().get(0).toString()));
        Assert.assertTrue(("[3 1] Invalid type of \"q2\"").equals(validation.getValidationErrors().get(1).toString()));
        Assert.assertTrue(("[4 1] Invalid type of \"q3\"").equals(validation.getValidationErrors().get(2).toString()));
    }

    @Test
    public void mathMistakeTest() throws FileNotFoundException, IOException {
        Form form = getFormForFile(INVALID_QUESTIONAIRE + "/math_mistake.txt");

        ASTValidation validation = form.validate(new Scope());
        Assert.assertTrue(validation.hasErrors());

        Assert.assertTrue(("[6 41] Invalid type of \"q1 + q3\"").equals(validation.getValidationErrors().get(0).toString()));
        Assert.assertTrue(("[6 1] Invalid type of \"q4\"").equals(validation.getValidationErrors().get(1).toString()));
    }

    @Test
    public void undefinedQuestionTest() throws FileNotFoundException, IOException {
        Form form = getFormForFile(INVALID_QUESTIONAIRE + "/undefined_question.txt");

        ASTValidation validation = form.validate(new Scope());
        Assert.assertTrue(validation.hasErrors());

        Assert.assertTrue(("[4 43] Variable \"q1\" not found").equals(validation.getValidationErrors().get(0).toString()));
        Assert.assertTrue(("[4 4] Invalid type of \"q1\"").equals(validation.getValidationErrors().get(1).toString()));
    }
}
