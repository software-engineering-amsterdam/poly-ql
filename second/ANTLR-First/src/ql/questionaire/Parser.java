package ql.questionaire;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import ql.ast.node.syntactic.Form;
import ql.grammar.QLLexer;
import ql.grammar.QLParser;
import ql.main.ASTCheckerError;

public class Parser {

	public static Form parse(String text) throws RecognitionException, ASTCheckerError {
		QLParser parser=null;
		InputStream inputStream = new ByteArrayInputStream(text.getBytes());
		TokenStream tokenStream;
		try {
			tokenStream = new CommonTokenStream(
					new QLLexer( new ANTLRInputStream( inputStream))
					);
			parser= new QLParser(tokenStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Form rootAST=parser.form().result;
		ASTChecker.check(rootAST);

		return rootAST;
	}
}