package edu.uva.softwarecons.main;

import edu.uva.softwarecons.grammar.QuestionnaireLexer;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
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
        System.out.println(tree.toStringTree(parser));// print LISP-style tree

        ParseTreeWalker walker = new ParseTreeWalker();
        Evaluator evaluator = new Evaluator();
        walker.walk(evaluator, tree);
         System.out.println("ss");
    }
}
