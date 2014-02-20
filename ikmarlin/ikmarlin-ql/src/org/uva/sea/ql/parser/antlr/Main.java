package org.uva.sea.ql.parser.antlr;

import java.io.IOException;
import java.util.HashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.TypeChecker;

public class Main {

	/**
	 * @param args
	 * @throws RecognitionException
	 * @throws IOException
	 */
	public static void main(String[] args) throws RecognitionException,
			IOException {
		String src = "form Box1HouseOwning { \n"
				+ "\thasSoldHouse: \"Did you sell a house in 2010?\" string \n"
				+ "\thasBoughtHouse: \"Did you buy a house in 2010?\" boolean \n"
				+ "\thasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n"
				+ "\tif (asSoldHouse) {\n"
				+ "\t\tsellingPrice: \"Price the house was sold for:\" integer \n"
				+ "\t\tprivateDebt: \"Private debts for the sold house:\" integer \n"
				+ "\t\tvalueResidue: \"Value residue:\" money(!privateDebt) \n"
				+ "\t}\n " + "}";
//		System.out.println(src);
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		Form f = parser.form();
		TypeChecker tc = new TypeChecker();
		HashMap<String, Type> st = tc.check(f);
		if(!tc.getErrors().isEmpty()){
			for(String error : tc.getErrors()){
				System.err.println(error);
			}
		}
	}
}
