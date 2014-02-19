package edu.uva.softwarecons.main;

import edu.uva.softwarecons.grammar.QuestionnaireLexer;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class Q {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        QuestionnaireLexer lexer = new QuestionnaireLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionnaireParser parser = new QuestionnaireParser(tokens);
        ParseTree tree = parser.questionnaire(); // parse
        System.out.println(tree.toStringTree(parser));// print LISP-style tree

        //eval.visit(tree);
    }
}
