package ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import ql.ast.expr.ExprType.Expr;
import ql.ast.form.Form;
import ql.parser.antlr.QLParser.FormContext;
import ql.parser.test.ParseError;

public class FormParser{
	
	public Form parseForm(String src) throws ParseError, IOException {
		QLParser parser = createParser(src);
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}
	
	private QLParser createParser(String src) throws IOException {
		InputStream is = new FileInputStream(src);
		ANTLRInputStream input = new ANTLRInputStream(is);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new QLParser(tokens);
	}

}
