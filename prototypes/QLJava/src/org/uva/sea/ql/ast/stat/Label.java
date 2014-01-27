package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.ASTNode;

public class Label implements ASTNode {
	private final String value;
	
	public Label(String value) {
		this.value = unquote(value);
	}
	
	public String getValue() {
		return value;
	}
	
	private static String unquote(String str) {
		return str.substring(1, str.length() - 1)
				.replaceAll("\\\\", "\\")
				.replaceAll("\\n", "\n")
				.replaceAll("\\t", "\t")
				.replaceAll("\\r", "\r");
	}
}
