package maintest;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;

import typecheck.Symboles;
import typecheck.TypeChecker;
import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.visitors.BaseVisitor;

public class TypeCheckerTest {
	
	@Test
	public void test(boolean expected, String str){
		System.out.println("Input String: " + str);
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.form().result;
		BaseVisitor visitor = new BaseVisitor();
		System.out.println(tree.accept(visitor));
		
		Symboles symb = new Symboles();
		TypeChecker checker = new TypeChecker(symb);
		boolean result = checker.check_symb(tree, symb);
		assertEquals(expected, result);
		
	}
	
	@Test
	public void testSymboles(){
		System.out.println("start test");
		test(true, "form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean }");
	}

}
