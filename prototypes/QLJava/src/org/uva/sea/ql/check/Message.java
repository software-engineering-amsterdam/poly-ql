package org.uva.sea.ql.check;

import org.uva.sea.ql.ast.ASTNode;

public class Message {
	private final String message;
	private final ASTNode ast;
	
	public Message(ASTNode ast, String message) {
		this.ast = ast;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return "MESSAGE: " + message;
	}

	public ASTNode getAST() {
		return ast;
	}
	
}
