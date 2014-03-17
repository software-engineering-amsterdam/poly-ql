package org.uva.sea.ql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	private String path;

	public Compiler(String path) {
		this.path = path;
	}

	public Form compile() {
		try {
			String formInput = readForm();
			ANTLRStringStream stream = new ANTLRStringStream(formInput);
			CommonTokenStream tokens = new CommonTokenStream();
			QLLexer lexer = new QLLexer(stream);
			tokens.setTokenSource(lexer);
			QLParser parser = new QLParser(tokens);
			Form form = parser.form();
			if (parser.hasErrors()) {
				errors.addAll(parser.getAllErrors());
			}
			return form;
		} catch (RecognitionException e) {
			throw new IllegalStateException(
					"Recognition exception is never thrown, only declared.");
		}
	}

	public String readForm() {
		String form = new String();
		FileReader fr;
		try {
			String current;
			fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while ((current = br.readLine()) != null) {
				form += current + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return form;
	}

	public List<String> getAllErrors() {
		return errors;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}
}
