package test.nl.uva;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import main.nl.uva.g4.FormGrammarLexer;
import main.nl.uva.g4.FormGrammarParser;
import main.nl.uva.parser.elements.statements.ParserForm;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
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
        // Get sample file input stream
        File file = new File("questionaire.txt");
        FileInputStream fis = new FileInputStream(file);

        // create a CharStream that reads from file input stream
        ANTLRInputStream input = new ANTLRInputStream(fis);

        // create a lexer that feeds off of input CharStream
        FormGrammarLexer lexer = new FormGrammarLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        FormGrammarParser parser = new FormGrammarParser(tokens);

        List<ParserForm> pf = parser.forms().data;

        for (ParserForm f : pf) {

            ASTValidation validation = f.validate(new Scope());
            Assert.assertFalse(validation.hasErrors());
        }
    }
}
