package maintest;

import gui.Evaluator;

import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;
import static org.junit.Assert.assertEquals;

import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Int;
import ast.expr.evaluate.Value;

public class EvaluatorTest {


	public void test(Value expected, String str) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.orExpr().result;
		Map<Identifier, Value> m = null;
		Value result = Evaluator.Evaluate((Expr) tree, m);
		if (expected instanceof Int){
			assertEqualsInt((Int) expected,(Int) result);
		} else if(expected instanceof Bool){
			assertEqualsBool((Bool) expected,(Bool) result);
		}
	}
	
	private void assertEqualsBool(Bool expected, Bool result) {
		assertEquals(expected.getValue(), result.getValue());
		
	}

	private void assertEqualsInt(Int expected, Int result) {
		assertEquals(expected.getValue(), result.getValue());		
	}

	@Test
	public void testArithmetic(){
		test(new Int(3), "1 + 2");
		test(new Int(2), "1 + 2 - 1");
		test(new Int(6), "(1 + 2) * 2");
		test(new Int(10), "20/2");
		test(new Int(12), "20/2 + 2");
		test(new Int(-2), "4 - (2 * 3) ");
		test(new Int(8), "4 - (2 * 3) + 10 ");
		test(new Int(0), "4 - (2 * 3) + 10/5 ");
		
	}
	@Test
	public void testBoolean(){
		test(new Bool(true), "3 > 2");
		test(new Bool(false), "3 < 2");
		test(new Bool(true), "3 < 5");
		test(new Bool(false), "true && false");
		test(new Bool(false), "false && false");
		test(new Bool(true), "true && true");
		test(new Bool(true), "true || true");
		test(new Bool(true), "true || false");
		test(new Bool(true), "(true && true) || false");
		test(new Bool(true), "(false || true) && true");
		test(new Bool(true), "!true == false");
		test(new Bool(true), "4 == 4");
		test(new Bool(true), "4 != 3");
		test(new Bool(true), "(10 - 3) == (6 + 1)");
		test(new Bool(true), "-4 == 2-6");
		test(new Bool(true), "+4 == 6-2");
	}

}
