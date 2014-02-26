package nl.uva.polyql;

import java.io.FileInputStream;
import java.io.IOException;

import nl.uva.polyql.antlr4.QuestionnaireLexer;
import nl.uva.polyql.antlr4.QuestionnaireParser;
import nl.uva.polyql.model.Form;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class ParserHelper {

    /** The path to the resources folder */
    public static final String RESOURCE_PATH = "res/";

    /**
     * Parses a file with QL and creates a form for it.
     * 
     * @param filename
     *            The absolute or relative filename of the QL file
     * 
     * @return The resulting form
     */
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

    /**
     * Parses a file from the resources folder and creates a form for it.
     * 
     * @param formname
     *            The name of the form excluding path and extension
     * 
     * @return The resulting form
     */
    public static Form parseResourceForm(final String formname) {
        return parseForm(RESOURCE_PATH + formname + ".txt");
    }
}
