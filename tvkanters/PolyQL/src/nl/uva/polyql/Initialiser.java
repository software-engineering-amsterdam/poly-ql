package nl.uva.polyql;

import java.io.FileInputStream;
import java.io.IOException;

import nl.uva.polyql.antlr4.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class Initialiser {

    public static void main(final String... params) {

        try {
            final ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("res/exampleform.txt"));
            final QuestionnaireLexer lexer = new QuestionnaireLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final QuestionnaireParser parser = new QuestionnaireParser(tokens);
            final ParseTree tree = parser.form();

            System.out.println(tree.toStringTree(parser));

        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
}
