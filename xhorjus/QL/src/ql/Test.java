package ql;

import ql.ast.*;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import antlr4.*;

/**
 * Test class to instantiate Test expression and do stuff.
 */
public class Test {
	public static void main(String[] args) throws IOException {
		// Create input stream from in.txt
		FileInputStream in = new FileInputStream("src/in.txt");
	    ANTLRInputStream input = new ANTLRInputStream(in);
	    
	    // Create lexer from input
	    TestLexer lexer = new TestLexer(input);
	    
	    // Create tokens from lexer
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    
	    // Create parser from tokens
	    TestParser parser = new TestParser(tokens);
	   
	    // Create tree from init rule
	    ParseTree tree = parser.questionnare();
	    
	    // Print tree. Tada.
	    System.out.println(tree.toStringTree(parser));
	    
	    // Create visitor
	    QLVisitor eval = new QLVisitor();
	    eval.visit(tree);
	}
}
