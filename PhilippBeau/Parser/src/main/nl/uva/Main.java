package main.nl.uva;

import java.io.File;
import java.io.FileInputStream;

import main.nl.uva.g4.FormGrammarLexer;
import main.nl.uva.g4.FormGrammarParser;
import main.nl.uva.parser.Form;
import main.nl.uva.ui.UI;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(final String[] args) throws Exception {
        File file = new File("questionaires/main.txt");
        FileInputStream fis = new FileInputStream(file);

        ANTLRInputStream input = new ANTLRInputStream(fis);

        FormGrammarLexer lexer = new FormGrammarLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FormGrammarParser parser = new FormGrammarParser(tokens);
        Form pf = parser.form().parsedForm;

        ASTValidation validation = pf.validateAndCalculate(new Scope());
        if (!validation.hasErrors()) {
            UI ui = new UI(pf);
            ui.setVisible(true);
        } else {
            validation.printErrors();
        }

        validation.printWarnings();
    }
}
