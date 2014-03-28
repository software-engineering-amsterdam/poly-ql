package org.uva.sea.ql.parser.test;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

public class BlockParser implements IParser<Stmt> {
	
	@Override
	public Stmt parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.block();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
}
