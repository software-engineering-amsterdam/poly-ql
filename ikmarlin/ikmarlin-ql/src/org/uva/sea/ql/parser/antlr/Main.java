package org.uva.sea.ql.parser.antlr;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.form.Form;

public class Main {

	/**
	 * @param args
	 * @throws RecognitionException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws RecognitionException, IOException {
		String src = "form Box1HouseOwning { \n" +
				"\thasSoldHouse: \"Did you sell a house in 2010?\" boolean \n" +
				"\thasBoughtHouse: \"Did you buy a house in 2010?\" boolean \n" +
				"\thasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n" +
				"\tif (hasSoldHouse) {\n" +
				"\t\tsellingPrice: \"Price the house was sold for:\" integer \n" +
				"\t\tprivateDebt: \"Private debts for the sold house:\" integer \n" +
				"\t}\n " +
				"}";
		System.out.println(src);
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		Form f = parser.form();
		System.out.println(f);
	}
}
