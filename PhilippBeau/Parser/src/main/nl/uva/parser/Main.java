package main.nl.uva.parser;

/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/
// import ANTLR's runtime libraries
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import main.nl.uva.g4.FormGrammarLexer;
import main.nl.uva.g4.FormGrammarParser;
import main.nl.uva.parser.elements.ParserForm;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(final String[] args) throws Exception {
        test3();
    }

    public static void test3() throws Exception {
        // Get sample file input stream
        File file = new File("questionaire.txt");
        FileInputStream fis = new FileInputStream(file);

        // create a CharStream that reads from file input stream
        ANTLRInputStream input = new ANTLRInputStream(fis);

        // create a lexer that feeds off of input CharStream
        FormGrammarLexer lexer = new FormGrammarLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        FormGrammarParser parser = new FormGrammarParser(tokens);

        List<ParserForm> pf = parser.forms().data;

        // rec(tree);
        // System.out.println(tree.getChildCount());

        // print LISP-style tree
        // System.out.println(tree.toStringTree(parser));

        int n = 1;
        for (Object o : tokens.getTokens()) {
            CommonToken token = (CommonToken) o;
            System.out.println("token(" + n + ") = " + token.getText().replace("\n", "\\n"));
            n++;
        }

    }

    public static void rec(final ParseTree child) {
        if (child.getChildCount() == 0) System.out.println(child.getText());

        for (int i = 0; i < child.getChildCount(); ++i) {
            rec(child.getChild(i));
        }
    }

    public static void test1() {
        // the input source
        String source = "value1,value2,\"value3.1,\"\",value3.2\"" + "\n"
                + "\"line\nbreak\",Bbb,end";

        // create an instance of the lexer
        FormGrammarLexer lexer = new FormGrammarLexer(new ANTLRInputStream(source));

        // wrap a token-stream around the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // when using ANTLR v3.3 or v3.4, un-comment the next line:
        tokens.fill();

        // traverse the tokens and print them to see if the correct tokens are created

        int n = 1;
        for (Object o : tokens.getTokens()) {
            CommonToken token = (CommonToken) o;
            System.out.println("token(" + n + ") = " + token.getText().replace("\n", "\\n"));
            n++;
        }
    }
}
