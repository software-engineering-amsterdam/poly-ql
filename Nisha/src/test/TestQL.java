package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr4.QLLexer;
import antlr4.QLParser;
import ast.ASTNode;
import ast.visitors.BaseVisitor;

public class TestQL {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String inputFile = "C:\\Users\\nisha\\workspace\\Nisha\\src\\test1.ql";
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(inputFile));
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		parser.setBuildParseTree(true);
		ASTNode tree = parser.forms().result;
		BaseVisitor visitor = new BaseVisitor();
		System.out.println(tree.accept(visitor));
	}
	}

