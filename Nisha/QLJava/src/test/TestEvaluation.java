package test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import antlr4.QLLexer;
import antlr4.QLParser;
import ast.ASTNode;
import ast.evaluate.Bool;
import ast.evaluate.Int;
import ast.evaluate.Value;
import expr.Ident;
import gui.Evaluation;

public class TestEvaluation {

	public void testing(Value val, String expression)
	{Map<Ident,Value> mapvalue= null;
		ANTLRInputStream inputfile = new ANTLRInputStream(expression);
		QLLexer lexer = new QLLexer(inputfile);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		parser.setBuildParseTree(true);
		ASTNode tree = parser.orExpr().result;
		Value result = tree.accept(new Evaluation(mapvalue));
		if(val instanceof Int)
		{
		assertEquals(((Int) val).getValue(), ((Int)result).getValue());	
		}else if (val instanceof Bool)
		{
			assertEquals(((Bool) val).getValue(), ((Bool)result).getValue());
		}
		
	}
	
	@Test
	public void testArithmatic() {
		testing(new Int(10), "5+5");
		testing(new Int(10), "(4+1) + (3+2)");
		testing(new Int(-10), "2-12");
		testing(new Int(10), "20/2");
		testing(new Int(10), "5*2");
		testing(new Int(12), "(3*3) + 3");
		testing(new Int(12), "(9-6) * 4");
		testing(new Int(33), "11 + (6*2) + 30/3");
	}

	@Test
	public void testConditional(){
		testing(new Bool(true), " 10000 > 9000");
		testing(new Bool(true), " (1+7) > (1-7)");
		testing(new Bool(true), "true && true");
		
	}
	

}
