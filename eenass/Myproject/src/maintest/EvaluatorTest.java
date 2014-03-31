package maintest;

import static org.junit.Assert.assertEquals;
import gui.render.Evaluator;

import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.binExpr.Add;
import ast.expr.binExpr.GT;
import ast.expr.binExpr.LT;
import ast.expr.binExpr.Mul;
import ast.expr.binExpr.Sub;
import ast.expr.literal.BoolLiteral;
import ast.expr.literal.IntLiteral;
import ast.expr.unExpression.Neg;
import ast.expr.unExpression.Not;
import ast.value.Bool;
import ast.value.Int;
import ast.value.Value;

public class EvaluatorTest {


	public void test(Value expected, String str) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.orExpr().result;
		Map<Identifier, Value> m = null;
		Value result = ((Expr) tree).accept(new Evaluator(m));
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
		test(new Bool(true), "3 <= 3");
		test(new Bool(true), "3 >= 3");
		test(new Bool(false), "5 <= 3");
		test(new Bool(true), "2 <= 3");
		test(new Bool(false), "5 >= 6");
		test(new Bool(false), "true && false");
		test(new Bool(false), "false && false");
		test(new Bool(true), "true && true");
		test(new Bool(true), "true || true");
		test(new Bool(true), "true || false");
		test(new Bool(true), "(true && true) || false");
		test(new Bool(true), "(false || true) && true");
		test(new Bool(false), "(false && true) && true");
		test(new Bool(false), " ! (false || true) && true");
		test(new Bool(true), "!true == false");
		test(new Bool(true), "4 == 4");
		test(new Bool(true), "4 != 3");
		test(new Bool(true), "(10 - 3) == (6 + 1)");
		test(new Bool(true), "-4 == 2-6");
		test(new Bool(true), "+4 == 6-2");
	}
	
	@Test
	public void testExpressions(){
		IntLiteral a = new IntLiteral(5);
		IntLiteral b = new IntLiteral(4);
		assertEqualValue(new Bool(true), Evaluate(new GT(a, b)));
		assertEqualValue(new Bool(false), Evaluate(new LT(a, b)));
		assertEqualValue(new Int(9), Evaluate(new Add(a, b)));
		assertEqualValue(new Int(1), Evaluate(new Sub(a, b)));
		assertEqualValue(new Int(20), Evaluate(new Mul(a, b)));
		assertEqualValue(new Int(-5), Evaluate(new Neg(a)));
		assertEqualValue(new Bool(true), Evaluate(new Not(new BoolLiteral(false))));
	}

	private void assertEqualValue(Value expected, Value value) {
		if (expected instanceof Int){
			assertEqualsInt((Int) expected,(Int) value);
		} else if(expected instanceof Bool){
			assertEqualsBool((Bool) expected,(Bool) value);
		}
	}
	private Value Evaluate(Expr expr){
		Map<Identifier, Value> m = null;
		return expr.accept(new Evaluator(m)); 
	}

}
