package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import typecheck.Typecheck;
import antlr4.QLLexer;
import antlr4.QLParser;
import ast.ASTNode;
import ast.type.Type;
import expr.Ident;

public class Testtypecheck {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<Ident,Type> mapvalue= new HashMap<Ident,Type>();
		
		String inputFile = "C:\\Users\\nisha\\Documents\\poly-ql\\Nisha\\QLJava\\src\\test1.ql";
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(inputFile));
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		parser.setBuildParseTree(true);
		ASTNode tree = parser.forms().result;
		Typecheck visitor = new Typecheck(mapvalue);
		System.out.println(tree.accept(visitor));

}
}
