package ql.parser.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import ql.ast.expr.exprType.Expr;
import ql.ast.form.Form;
import ql.parser.antlr.QLParser.FormContext;
import ql.parser.test.ParseError;

public class FormParser{
	
	//get the parser for a file
	private QLParser createFileParser(String src) throws IOException {
		InputStream is = new FileInputStream(src);
		ANTLRInputStream input = new ANTLRInputStream(is);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new QLParser(tokens);
	}

	//get the parser for a String
	private QLParser createStringParser(String src) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(src);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new QLParser(tokens);
	}
	
	public Form parseForm(String src) throws ParseError, IOException {
		QLParser parser = createStringParser(src);
		try {
			return parser.form().result;
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
