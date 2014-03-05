package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.ASTNode;

public class Parser {
	
	public ASTNode parser(String input) throws ParseException{

		QLLexer lexer = new QLLexer(new StringReader(input));
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		
		if(!parser.parse()){
			throw new ParseException("parse error");
		}
		
		return parser.getResult();
		
		}
}
