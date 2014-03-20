package org.uva.sea.ql.parser.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

public class FormParser implements IParser<Form> {

	@Override
	public Form parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	public Form parse(File file) throws ParseError {
		String src = readFile(file);
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	private String readFile(File file) {
		String src = "";
		FileReader fr;
		try {
			String current;
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((current = br.readLine()) != null) {
				src += current + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return src;
	}
}
