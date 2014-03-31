package tests;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.expr.binExpr.Add;
import ast.expr.binExpr.And;
import ast.expr.binExpr.Div;
import ast.expr.binExpr.Mul;
import ast.expr.binExpr.Or;
import ast.expr.binExpr.Sub;
import ast.expr.literal.BoolLiteral;
import ast.expr.literal.IntLiteral;
import ast.expr.literal.StrLiteral;
import ast.expr.unExpr.Neg;
import ast.expr.unExpr.Not;
import ast.expr.unExpr.Pos;

public class TestExpression {

	
	public void test(Object expected, String str){
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.orExpr().result;
		assertEquals(expected, tree.getClass());
		
	}
	
	@Test
	public void testLiterals(){
		IntLiteral a = new IntLiteral(5);
		BoolLiteral x = new BoolLiteral(true);
		StrLiteral s = new StrLiteral("emmy");
		assert(a instanceof IntLiteral);
		assert(x instanceof BoolLiteral);
		assert(s instanceof StrLiteral);
	}

	@Test
	public void testUnExpr(){
		IntLiteral a = new IntLiteral(5);
		assert(new Neg(a) instanceof Neg);
		assert(new Pos(a) instanceof Pos);
		assert(new Not(a) instanceof Not);
		test(Neg.class, "-a");
		test(Pos.class, "+a");
		test(Not.class, "!a");
	}
	
	@Test
	public void testBinExpr(){
		IntLiteral a = new IntLiteral(5);
		IntLiteral b = new IntLiteral(5);
		IntLiteral c = new IntLiteral(5);
		BoolLiteral x = new BoolLiteral(true);
		BoolLiteral y = new BoolLiteral(true);
		BoolLiteral z = new BoolLiteral(true);
		assert(new Add(a, b) instanceof Add);
		assert(new Add(new Add(a, b), c) instanceof Add);
		assert(new Sub(a, b) instanceof Sub);
		assert(new Sub(new Add(a, b), c) instanceof Sub);
		assert(new Div(a, b) instanceof Div);
		assert(new Div(new Add(a, b), c) instanceof Div);
		assert(new Mul(a, b) instanceof Mul);
		assert(new Mul(new Add(a, b), c) instanceof Mul);
		assert(new And(x, y) instanceof And);
		assert(new And(new Or(x, y), z) instanceof And);
		assert(new Or(x, y) instanceof Or);
		assert(new Or(new And(x, y), z) instanceof Or);
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
