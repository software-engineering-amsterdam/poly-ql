package org.uva.sea.ql.parser.antlr.QL4.Messages;

public class QLErrorMsg {
	private final String msg;
	
	public QLErrorMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
	}
}
