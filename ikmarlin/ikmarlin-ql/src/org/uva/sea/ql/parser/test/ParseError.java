package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.checker.exception.QLException;


public class ParseError extends QLException  {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public ParseError(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
	
}