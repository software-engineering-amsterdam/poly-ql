package maintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.visitors.BaseVisitor;

public class TestQLang {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File in = new File("C:\\Users\\E. Butrus\\Dropbox\\MASTER\\SoftwareCon\\poly-ql\\eenass\\Myproject\\src\\maintest\\test.txt");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(in));
		System.out.println("start test " + input);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		parser.setBuildParseTree(true);
		ASTNode tree = parser.init().result;
		BaseVisitor visitor = new BaseVisitor();
		System.out.println(tree.accept(visitor));
	}

}
