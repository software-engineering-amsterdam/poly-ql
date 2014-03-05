package edu.uva.softwarecons.main;

import edu.uva.softwarecons.checker.TypeChecker;
import edu.uva.softwarecons.grammar.QuestionnaireBuilderVisitor;
import edu.uva.softwarecons.grammar.QuestionnaireLexer;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
import edu.uva.softwarecons.model.Form;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = null;

        if (args.length > 0) inputFile = args[0];
        InputStream inputStream = System.in;
        if (inputFile != null) inputStream = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QuestionnaireLexer lexer = new QuestionnaireLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionnaireParser parser = new QuestionnaireParser(tokens);
        ParseTree tree = parser.questionnaire(); // parse
        QuestionnaireBuilderVisitor questionnaireBuilderVisitor = new QuestionnaireBuilderVisitor();
        Form form = (Form) questionnaireBuilderVisitor.visit(tree);
//        form.accept(new FormPrintVisitor());
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm(form);
        System.out.print("");
    }
}
