package org.uva.sea.ql.parser.antlr.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.uva.sea.ql.parser.antlr.QL4.QL4;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

/**
 * Abstract parent class of most test classes. 
 * Provides a global setup before each test,
 * which simply includes running the QL4 parser.
 * @author Sammie
 *
 */
public abstract class QL4Test {

	public static String fileToParse = "";
	public Form ast;
	public List<QLErrorMsg> errors, expected;
	
	@Before 
	public void setUp() {
		QL4 ql4 = new QL4();
		
		try {
			ast = ql4.parseQuestionair(fileToParse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		errors = ql4.checkErrors(ast);
		expected = new ArrayList<QLErrorMsg>();
	}
	
	public static void setFile(String path) {
		fileToParse = path;
	}
}
