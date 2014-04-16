package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;


/**
 * Visits QLErrorMsg and returns GUI text element
 * @author Sammie Katt
 */
public class GUIErrorVisitor extends Visitor {

	public String visit(QLErrorMsg error) {
		return error.toString();
	}
}
