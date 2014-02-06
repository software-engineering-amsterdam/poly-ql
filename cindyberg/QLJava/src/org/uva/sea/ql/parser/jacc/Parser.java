package org.uva.sea.ql.parser.jacc;

public class Parser {
	public static void main(String[] args)
	{
		QLLexer lexer = new QLLexer(null);
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		parser.parse();
	}

	static void error(String msg){
		System.out.println("ERROR: " + msg);
		System.exit(1);
	}

}
