package maintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.*;

public class TestQLang {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File in = new File("test/t1.txt");
		System.out.println("start test");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(in));
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.unExpr();
		System.out.println(tree.toStringTree(parser));
	}

}
