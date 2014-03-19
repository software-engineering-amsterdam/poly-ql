package test.nl.uva;

import java.io.IOException;

import main.nl.uva.g4.FormGrammarLexer;
import main.nl.uva.g4.FormGrammarParser;
import main.nl.uva.parser.element.Form;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParserTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @Test
    public void parserTest() throws IOException {
        // create a CharStream that reads from file input stream
        ANTLRInputStream input = new ANTLRInputStream(
                "form Box1HouseOwning { \n hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"
                        + "hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n" + "moneyBling: \"How much money?\" money \n"
                        + "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n" + "if (hasMaintLoan) {\n"
                        + "sellingPrice: \"Price the house was sold for:\" money\n"
                        + "privateDebt: \"Private debts for the sold house:\" money\n" + "test: \"Test\" boolean\n"
                        + "valueResidue: \"Value residue:\" money(sellingPrice - privateDebt)\n" + "if (privateDebt == 3) {\n"
                        + "manyDept: \"Price the house was sold for:\" money(privateDebt*9)\n" + "}\n" + "}\n" + "}");

        // create a lexer that feeds off of input CharStream
        FormGrammarLexer lexer = new FormGrammarLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        FormGrammarParser parser = new FormGrammarParser(tokens);

        Form pf = parser.form().parsedForm;

        ASTValidation validation = pf.validate(new Scope());
        validation.printErrors();
        Assert.assertFalse(validation.hasErrors());

    }
}
