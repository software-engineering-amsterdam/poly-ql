package org.uva.sea.ql.parser.antlr.Form2;

import Form2.Form2BaseVisitor;
import Form2.Form2Parser;

public class Form2CustomVisitor extends Form2BaseVisitor {
	
	public Object visitLabel(Form2Parser.LabelContext ctx) {
		System.out.println(ctx.getText());
		return ctx;
	}
}
