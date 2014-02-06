package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.ASTNode;

public class Parser {
	
	public ASTNode parser(String input){

		QLLexer lexer = new QLLexer(new StringReader(input));
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		
		parser.parse();
		return parser.getResult();
		
		}
	
	static void error(String msg) {
		   System.out.println("ERROR: " + msg);
		   System.exit(1);
		}
}
