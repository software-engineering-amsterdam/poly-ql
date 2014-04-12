package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.NeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.AndExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.PlusExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

public class EvaluateBigTest extends QL4EvaluationTest {

	Number num1 = new Number("10");
	Number num2 = new Number("13");
	Decimal dec1 = new Decimal("6.7");
	Decimal dec2 = new Decimal("10.2");
	Bool bool1 = new Bool("true");
	Bool bool2 = new Bool("false");
	Text string1 = new Text("String stuff");
	Text string2 = new Text("String stuff2");
	
	@Test
	public void test() {
		PlusExpr plus = new PlusExpr(num1, dec1); // 16.7
		MultExpr mult = new MultExpr(plus, num2); // 16.7 * 13
		GeqExpr geq = new GeqExpr(dec2, mult); // false
		BraceExpr brace = new BraceExpr(geq); // (false);
		NeqExpr neq = new NeqExpr(string1, string2); // true
		AndExpr and = new AndExpr(brace, neq); // false
		
		double outcome = 16.7 * 13;
		
		assertEquals(new Decimal("16.7"), visitor.visit(plus));
		assertEquals(new Decimal(String.valueOf(outcome)), visitor.visit(mult));
		
		assertEquals(new Bool("true"), visitor.visit(neq));
		assertEquals(new Bool("false"), visitor.visit(brace));
		assertEquals(new Bool("false"), visitor.visit(and));
		assertEquals(new Bool("false"), visitor.visit(geq));
		
	}
}
