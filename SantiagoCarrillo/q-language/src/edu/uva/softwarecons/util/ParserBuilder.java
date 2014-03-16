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


    private QuestionnaireLexer lexer;

    private CommonTokenStream tokens;

    private QuestionnaireParser parser;


    public ParseTree buildParseTree(String inputText){
        return getParseTree(new ANTLRInputStream(inputText));
    }

    public ParseTree buildParseTree(InputStream inputStream) throws IOException {
        return getParseTree(new ANTLRInputStream(inputStream));
    }

    private ParseTree getParseTree(ANTLRInputStream input) {
        lexer = new QuestionnaireLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new QuestionnaireParser(tokens);
        return parser.questionnaire();
    }


    public QuestionnaireParser getParser() {
        return parser;
    }
}
