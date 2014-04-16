package org.uva.sea.ql.parser.antlr.QL4;

import java.io.IOException;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

/**
 * Main function for QL4 questionair
 */
public class Questionair {

	// managers for generating and displaying QL4 elements
	private ASTManager astManager = new ASTManager();
	
	/**
	 * Constructor parses default file "test/plainTest"
	 */
	public Questionair() {
		this("test/plainTest");
	}
	
	/**
	 * Constructor parses input file
	 */
	public Questionair(String fileToParse) {
		Form ast = getForm(fileToParse);
		List<QLErrorMsg> errors = getErrors(ast);
		GUIManager guiManager = new GUIManager(ast, errors);
		guiManager.run();
	}
	
	/**
	 * Returns a form, given filetoparse is set als private field
	 * @return
	 */
	private Form getForm(String fileToParse) {
		Form ast = null;
		
		try {
			ast = astManager.parseQuestionair(fileToParse);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ast;
	}
	
	/**
	 * Returns the errors of an form
	 */
	private List<QLErrorMsg> getErrors(Form ast) {
		return astManager.checkErrors(ast);
	}
}

