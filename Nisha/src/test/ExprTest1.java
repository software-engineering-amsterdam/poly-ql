package test;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import expr.Ident;
import expr.operation.Add;
import expr.relational.Eq;
import expr.relational.GEq;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;
import expr.relational.NEq;
import antlr4.QLLexer;
import antlr4.QLParser;
import ast.ASTNode;

public class ExprTest1  {

	public void testing(Object opclass, String str){
		ANTLRInputStream inputfile = new ANTLRInputStream(str);
		QLLexer lexer = new QLLexer(inputfile);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ASTNode tree = parser.orExpr().result;
		assertEquals(opclass, tree.getClass());
		
	}
	
	@Test
	public void testAdd()  {
		testing(Add.class, "a + b");
		testing(Add.class, "a + b + c");
		testing(Add.class, "a + (b + c)");
		testing(Add.class, "(a + b) + c");
		testing(Add.class, "a + b * c");
		
		}
	
	@Test
	public void testRels() {
		
		testing(LT.class, "a < (b * c)");
		testing(GT.class, "a > b");
		testing(LEq.class, "(a <= b)");
		testing(GEq.class, "(a >= b)");
		testing(Eq.class, "(a == b)");
		testing(NEq.class, "( a != b)");
		}

	@Test
	public void testIdent() {
		testing(Ident.class, "hasSoldhouse");
		testing(Ident.class, "abcds1234");
		testing(Ident.class, "Nisha1990Jacob");
	}
	
	
}
