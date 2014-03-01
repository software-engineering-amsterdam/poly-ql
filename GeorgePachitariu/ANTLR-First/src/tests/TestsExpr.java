package tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.junit.Test;

import expr.Expression;
import expr.Ident;
import expr.arithmeticExpr.Add;
import expr.arithmeticExpr.Div;
import expr.arithmeticExpr.Mul;
import expr.arithmeticExpr.Sub;
import expr.conditionalExpr.And;
import expr.conditionalExpr.Or;
import expr.literals.*;
import expr.relationalExpr.Eq;
import expr.relationalExpr.GEq;
import expr.relationalExpr.GT;
import expr.relationalExpr.LEq;
import expr.relationalExpr.LT;
import expr.relationalExpr.NEq;
import expr.signExpr.Neg;
import expr.signExpr.Not;
import expr.signExpr.Pos;
import parser.QLLexer;
import parser.QLParser;

public class TestsExpr {

	public static QLParser getParser(String input) {
		QLParser parser=null;
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		TokenStream tokenStream;
		try {
			tokenStream = new CommonTokenStream(
					new QLLexer( new ANTLRInputStream( inputStream))
					);
			parser= new QLParser(tokenStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parser; 
	}		

	@Test
	public void testPrimaryInt() throws RecognitionException  {
		String str="1";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.primary().result;
		
		Expression expected=new Int(1);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPrimaryIdent() throws RecognitionException  {
		String str="question";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.primary().result;
		
		Expression expected=new Ident("question");
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPrimaryParanth() throws RecognitionException  {
		String str="(3)";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.primary().result;
		
		Expression expected=new Int(3);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testUnExprPos() throws RecognitionException  {
		String str="+1";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.unExpr().result;
		
		Expression expected=new Pos(new Int(1));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testUnExprNeg() throws RecognitionException  {
		String str="-1";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.unExpr().result;
		
		Expression expected=new Neg(new Int(1));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testUnExprNot() throws RecognitionException  {
		String str="!ab";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.unExpr().result;
		
		Expression expected=new Not(new Ident("ab"));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testUnExprSimple() throws RecognitionException  {
		String str="1";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.unExpr().result;
		
		Expression expected=new Int(1);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMulExprMul() throws RecognitionException  {
		String str="1*3";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.mulExpr().result;
		
		Expression expected=new Mul(new Int(1),new Int(3));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMulExprDiv() throws RecognitionException  {
		String str="1/3";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.mulExpr().result;
		
		Expression expected=new Div(new Int(1),new Int(3));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMulExprCombined() throws RecognitionException  {
		String str="6*2/3";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.mulExpr().result;
		
		Expression expected=new Div(new Mul(new Int(6),(new Int(2))),new Int(3));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testAddExprAdd() throws RecognitionException  {
		String str="6+2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.addExpr().result;
		
		Expression expected=new Add(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testAddExprSub() throws RecognitionException  {
		String str="6-2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.addExpr().result;
		
		Expression expected=new Sub(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRelExprLT() throws RecognitionException  {
		String str="6<2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.relExpr().result;
		
		Expression expected=new LT(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRelExprLEq() throws RecognitionException  {
		String str="6<=2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.relExpr().result;
		
		Expression expected=new LEq(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRelExprGT() throws RecognitionException  {
		String str="6>2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.relExpr().result;
		
		Expression expected=new GT(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRelExprGEq() throws RecognitionException  {
		String str="6>=2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.relExpr().result;
		
		Expression expected=new GEq(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRelExprEq() throws RecognitionException  {
		String str="6==2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.relExpr().result;
		
		Expression expected=new Eq(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRelExprNEq() throws RecognitionException  {
		String str="6!=2";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.relExpr().result;
		
		Expression expected=new NEq(new Int(6),new Int(2));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testAndExpr() throws RecognitionException  {
		String str="fst&&snd";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.andExpr().result;
		
		Expression expected=new And(new Ident("fst"),new Ident("snd"));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testOrExpr() throws RecognitionException  {
		String str="fst||snd";
		QLParser parser=TestsExpr.getParser(str);
		
		Expression actual=parser.orExpr().result;
		
		Expression expected=new Or(new Ident("fst"),new Ident("snd"));
		Assert.assertEquals(expected, actual);
	}		  
}
