package edu.uva.softwarecons.util;

import edu.uva.softwarecons.grammar.QuestionnaireLexer;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class ParserBuilder {

    private ANTLRInputStream input;

    private QuestionnaireLexer lexer;

    private CommonTokenStream tokens;

    private QuestionnaireParser parser;


    public ParseTree buildParseTree(String inputText){
        input = new ANTLRInputStream(inputText);
        lexer = new QuestionnaireLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new QuestionnaireParser(tokens);
        return parser.questionnaire();
    }

    public ParseTree buildParseTree(InputStream inputStream){
        //TODO Extract method to avoid duplicate code
        ParseTree tree = null;
        try {
            input = new ANTLRInputStream(inputStream);
            lexer = new QuestionnaireLexer(input);
            tokens = new CommonTokenStream(lexer);
            parser = new QuestionnaireParser(tokens);
            tree = parser.questionnaire();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tree;
    }



    public QuestionnaireParser getParser() {
        return parser;
    }
}
