package edu.uva.softwarecons.test;

import edu.uva.softwarecons.grammar.QuestionnaireBuilderVisitor;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.util.FileReader;
import edu.uva.softwarecons.util.ParserBuilder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;

import java.io.IOException;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/7/14
 */
public class QuestionnaireBuilderTest {


    private ParserBuilder parserBuilder;

    private Form form;

    @Before
    public void setUp() {
        //TODO not rely on input.txt create a seperate file
        parserBuilder = new ParserBuilder();
        try {
            ParseTree tree = parserBuilder.buildParseTree(FileReader.getFileContent("input.txt", "res"));
            QuestionnaireBuilderVisitor questionnaireBuilderVisitor = new QuestionnaireBuilderVisitor();
            form  = (Form) questionnaireBuilderVisitor.visit(tree);
        } catch (IOException e) {
            assert false : "Error reading the input file for the QuestionnaireBuilderTest";
        }
    }



}
