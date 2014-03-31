package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.StatementParser;
import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.statement.Statement;

public class ParserTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File in = new File("..\\QLanguage\\src\\tests\\test.txt");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(in));
		System.out.println("start test " + input);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		parser.setBuildParseTree(true);
		ASTNode tree = parser.init().result;
		StatementParser visitor = new StatementParser();
		System.out.println(((Statement) tree).accept(visitor));
	}

}
