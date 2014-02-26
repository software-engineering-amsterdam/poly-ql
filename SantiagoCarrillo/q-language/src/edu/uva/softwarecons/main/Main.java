package edu.uva.softwarecons.main;

import edu.uva.softwarecons.grammar.QuestionnaireEvalVisitor;
import edu.uva.softwarecons.grammar.QuestionnaireLexer;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.visitor.FormVisitor;
import edu.uva.softwarecons.visitor.IFormElement;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = null;

        if ( args.length>0 ) inputFile = args[0];
        InputStream inputStream = System.in;
        if ( inputFile!=null ) inputStream = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QuestionnaireLexer lexer = new QuestionnaireLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionnaireParser parser = new QuestionnaireParser(tokens);
        ParseTree tree = parser.questionnaire(); // parse
        QuestionnaireEvalVisitor questionnaireEvalVisitor = new QuestionnaireEvalVisitor();
        IFormElement form  = (Form) questionnaireEvalVisitor.visit(tree);
        form.accept(new FormVisitor());
    }
}
