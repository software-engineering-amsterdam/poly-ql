package antlr4;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import test.ParseError;
import ast.form.Form;
import expr.Expr;
public class FormParser {
	
	private QLParser createFileParser(String src) throws IOException {
		InputStream is = new FileInputStream(src);
		ANTLRInputStream input = new ANTLRInputStream(is);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new QLParser(tokens);
		
	}
	
	private QLParser createStringParser(String src) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(src);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new QLParser(tokens);
	}

	public Form parseForm(String src) throws ParseError, IOException {
		QLParser parser = createFileParser(src);
		try {
			return parser.forms().result;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}	

	public Expr parseExpr(String src) throws ParseError, IOException {
		QLParser parser = createStringParser(src);
		try {
			return parser.orExpr().result;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}
}
