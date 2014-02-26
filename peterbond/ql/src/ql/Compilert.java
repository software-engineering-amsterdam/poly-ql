package ql;
import antlr4.*;
//import ql.ast.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileInputStream;

public class Compilert {
	public static void main(String args[]) throws Exception {
		File file = new File(System.getProperty("user.dir") + "/src/questions.txt");
		FileInputStream fis = new FileInputStream(file);
		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(fis);
		// create a lexer that feeds off of input CharStream
		QLLexer lexer = new QLLexer(input);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.questionnaire();// begin parsing
		System.out.println(tree.toStringTree(parser));// print LISP-style tree
		// Create visitor
		//MyQLVisitor visitor = new MyQLVisitor();
		//visitor.visit(tree);
		// Etc.........
	}
}
