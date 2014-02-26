package nl.uva.polyql;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import nl.uva.polyql.antlr4.QuestionnaireLexer;
import nl.uva.polyql.antlr4.QuestionnaireParser;
import nl.uva.polyql.model.Form;

public class ParserHelper {

    public static final String RESOURCE_PATH = "res/";

    public static Form parseResourceForm(final String formname) {
        return parseForm(RESOURCE_PATH + formname + ".txt");
    }

    public static Form parseForm(final String filename) {
        try {
            final ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(filename));
            final QuestionnaireLexer lexer = new QuestionnaireLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final QuestionnaireParser parser = new QuestionnaireParser(tokens);
            return parser.form().f;

        } catch (final IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
