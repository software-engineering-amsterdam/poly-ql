package org.uva.sea.ql;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

public class Compiler {

	private List<String> errors = new ArrayList<String>();

	public Form compile(String src) {
		try {
			ANTLRStringStream stream = new ANTLRStringStream(src);
			CommonTokenStream tokens = new CommonTokenStream();
			QLLexer lexer = new QLLexer(stream);
			tokens.setTokenSource(lexer);
			QLParser parser = new QLParser(tokens);
			Form form = parser.form();
		    if (parser.hasErrors()){
		    	errors.addAll(parser.getAllErrors());
		    }
	    	return form;
		} catch (RecognitionException e) {
			throw new IllegalStateException(
					"Recognition exception is never thrown, only declared.");
		}
	}

	public List<String> getAllErrors() {
		return errors;
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
}
