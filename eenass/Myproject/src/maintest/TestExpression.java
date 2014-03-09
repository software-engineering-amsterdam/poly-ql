package maintest;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.expr.binExpr.Add;
import ast.expr.binExpr.Div;
import ast.expr.binExpr.Mul;
import ast.expr.binExpr.Sub;
import ast.expr.unExpression.Neg;
import ast.expr.unExpression.Not;
import ast.expr.unExpression.Pos;

public class TestExpression {

	
	public void test(Object expected, String str){
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.orExpr().result;
				
//		Symboles symb = new Symboles();
//		ErrorList errors= new ErrorList();
//		TypeChecker checker = new TypeChecker(symb, errors);
//		boolean result = checker.check_symb(tree, symb, errors);
//		if(!result) System.out.print(checker.get_errorList());
		assertEquals(expected, tree.getClass());
		
	}
	
	@Test
	public void testUnExpr(){
		test(Neg.class, "-a");
		test(Pos.class, "+a");
		test(Not.class, "!a");
	}
	
	@Test
	public void testBinExpr(){
		test(Add.class, "a + b");
		test(Add.class, "a + b + c");
		test(Sub.class, "a - b");
		test(Sub.class, "(a + b) - c");
		test(Div.class, "a / b");
		test(Div.class, "(a + b) / c");
		test(Mul.class, "a * b");
		test(Mul.class, "(a + b) * c");
		
	}

}
