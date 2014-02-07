package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.parser.jacc.Parser;

public abstract class TestParser {

	public Parser parser;
	
	public TestParser(){
		this.parser = new Parser();
	}
	
}
