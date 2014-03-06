package maintest;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;

import typecheck.ErrorList;
import typecheck.Symboles;
import typecheck.TypeChecker;
import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.expr.unExpression.Neg;

public class TestExpression {

	
	public void test(Object expected, String str){
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.form().result;
				
		Symboles symb = new Symboles();
		ErrorList errors= new ErrorList();
		TypeChecker checker = new TypeChecker(symb, errors);
		boolean result = checker.check_symb(tree, symb, errors);
		if(!result) System.out.print(checker.get_errorList());
		assertEquals(expected, result);
		
	}
	
	public void testUnExpr(){
		test(Neg.class, "-a");
	}

}
