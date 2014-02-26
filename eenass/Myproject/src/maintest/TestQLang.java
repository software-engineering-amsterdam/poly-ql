package maintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;

import antlr.*;
import ast.BaseVisitor;
import ast.expr.Expr;

public class TestQLang {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File in = new File("C:\\Users\\E. Butrus\\Dropbox\\MASTER\\SoftwareCon\\poly-ql\\eenass\\Myproject\\src\\maintest\\test.txt");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(in));
		System.out.println("start test " + input);
		Token token;
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		parser.setBuildParseTree(true);
		RuleContext t = parser.unExpr();
		t.inspect(parser);
		Expr tree = parser.unExpr().result;
		BaseVisitor visitor = new BaseVisitor();
		tree.accept(visitor);
	}

}
