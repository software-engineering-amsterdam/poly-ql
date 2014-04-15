package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import typecheck.Typecheck;
import antlr4.QLLexer;
import antlr4.QLParser;
import ast.ASTNode;
import ast.type.Type;
import expr.Ident;
import ast.form.Form;
import ast.errormsg.Error;
public class TypeCheckTest {
	


	public void test(boolean expected, String str){
		Map<Ident,Type> mapvalue= new HashMap<Ident,Type>();
		Error errors= new Error();
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ASTNode tree = parser.forms().result;
		Typecheck visitor = new Typecheck(mapvalue, errors);
	    boolean result = ((Form)tree).accept(visitor);
	    if(result==true)
	    {int i=1;
	    	System.out.println("The given input is correct!!!");
	    	System.out.println(" ");
	    }
	    System.out.print(visitor.get_errorList());
	    System.out.println(" ");
	    System.out.println(expected + "=" + result);
	    assert(expected == result);
	    
}
	@Test
	public void Formtest() {
		System.out.println("######## Testing the Form ############");
		System.out.println("FORM TEST 1");
		test(true, "form Box1HouseOwning {"+
                   "hasSoldHouse: \"Did you sell a house in 2010?\" boolean"+"\n"+
                   "hasBoughtHouse: \"Did you buy a house in 2010?\" boolean"+"\n"+
                   "hasMainLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean"+"\n"+
                   "if(hasSoldHouse == true) {"+"\n"+
                   "sellingPrice: \"Price the house was sold for:\" integer"+ "\n"+
                   "privateDebt: \"Private debts for the sold house:\" integer"+"\n"+
                   "valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)"+"\n"+
                   "}"+ "\n"+
                   "else{"+"\n"+
                   "if(hasBoughtHouse == True) {"+"\n"+
                   "buyingPrice: \"Price the house was bought for:\" integer"+"\n"+
                   " privateDebt1: \"Private debts for the sold house:\" integer"+"\n"+
                   " valueResidue1: \"Value residue:\" integer(buyingPrice + privateDebt)"+"\n"+
                   "}"+
                   "}"+
                   "}");
		System.out.println("FORM TEST 2");
		test(false , "form Box1HouseOwning {"+
                "hasSoldHouse: \"Did you sell a house in 2010?\" boolean"+"\n"+
                "hasBoughtHouse: \"Did you buy a house in 2010?\" boolean"+"\n"+
                "hasMainLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean"+"\n"+
                "if(hasSoldHouse == 10) {"+"\n"+
                "sellingPrice: \"Price the house was sold for:\" integer"+ "\n"+
                "privateDebt: \"Private debts for the sold house:\" integer"+"\n"+
                "valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)"+"\n"+
                "}"+
                "}");
//		System.out.println("FORM TEST 3");
//		test(false , "form Box1HouseOwning {"+
//               " hasSoldHouse: \"Did you sell a house in 2010?\" boolean"+"\n"+
//                "hasBoughtHouse: \"Did you buy a house in 2010?\" boolean"+"\n"+
//                "hasMainLoan: \"Did you buy a house in 2010?\" boolean"+"\n"+
//                "if(hasBoughtHouse == true) {"+"\n"+
//                "sellingPrice: \"Price the house was sold for:\" integer"+ "\n"+
//                "privateDebt: \"Private debts for the sold house:\" integer"+"\n"+
//                "valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)"+"\n"+
//                "}"+
//		
//                "}");
		System.out.println("FORM TEST 4");
		test(false, "form form1 { sellingPrice: \"Price the house was sold for:\" integer" + "\n"+
				"if(sellingPrice > 1000){" +"\n"+
				"sellingPrice: \"Private debts for the sold house:\" integer }"+"\n"+
				"}");
	}
	
	@Test
	public void Literaltest(){
		System.out.println("############ Testing the Literals ##############");
		System.out.println("");
		System.out.println("LITERAL TEST 1");
	test(false, "form form1 {\n " +
			     "q1 : \"Is it a Boolean literal?\" boolean(12) \n"+
			     "}");
	System.out.println("LITERAL TEST 2");
	test(true, "form form1 { q2 : \"Is it a Boolean literal\" boolean(false) }");
	System.out.println("LITERAL TEST 3");
	test(true, "form form1 { q3 : \"Is it a Integer literal?\" integer(12) }");
	System.out.println("LITERAL TEST 4");
	test(true, "form form1 { q4: \"Is it a String literal?\" string(\"abc\") }");
	System.out.println("LITERAL TEST 5");
	test(false, "form form1 { q5: \"Is it a String literal?\" string(123) }");
	
	}
	
	@Test
	public void UnExprtest(){
		System.out.println("############ Testing the Unary Expression ############");
		System.out.println("UNEXPR TEST 1");
test(true, "form form1 { q1 : \"a question\" boolean(!q1)}");
System.out.println("UNEXPR TEST 2");
test(false, "form form1 { q1 : \"a question\" boolean(!1)}");
	
	}
		
		@Test
		public void BinExprtest(){
			System.out.println("########### Testing the Binary Expression ###########");
			System.out.println("BINEXPR TEST 1");
		test(true, "form form1 { q1 : \"a question\" integer(4-2) }");
		System.out.println("BINEXPR TEST 2");
		test(false, "form form1 { q1 : \"a question\" integer(17 / false)}");
		
		}
		
		
		
		
		@Test
		public void Ifstatementtest(){
			System.out.println("############## Testing the If statement #############");
			System.out.println("IFSTATE TEST 1");
		test(true, "form form1 { x : \"a question\" boolean"+"\n"+
				"if(x == true) {q1 : \"a question\" boolean(true)}}");
		System.out.println("IFSTATE TEST 2");
	test(false, "form form1 { x : \"a question\" boolean"+"\n"+
			"if(x == 1) {q1 : \"a question\" boolean(true)}}");
		}
		
		
		@Test
		public void IfElsetest(){
			System.out.println("############## Testing the IfElse statement #############");
			System.out.println("IFELSE TEST 1");
			test(true, "form part1 { x : \"Is it a ifelse statement\" boolean"+ "\n"+
				 	   "if(x == false) {q1 : \"a question\" boolean(true)}"+"\n"+
			           "else{q2 : \"a question2\" boolean" + "\n" +
			           "}"+
			           "}");
	      System.out.println("IFELSE TEST 2");
           test(false, "form part2 { x : \"a question\" boolean"+"\n"+
		                "if(x == true) {q1 : \"a question\" boolean(true)}" + "\n" +
		                "else{q1 : \"a question2\" boolean(true)" + "\n" +
		                "}"+
		                 "}");
           System.out.println("IFELSE TEST 3");
           test(false, "form part3 { x : \"a question\" boolean"+"\n"+
   				       "if(x > 5) {q1 : \"a question\" boolean(true)}"+"\n"+
   		               "else{q2 : \"a question2\" boolean" + "\n" +
   				       "}"+
		               "}");
		}
		
		
	}


