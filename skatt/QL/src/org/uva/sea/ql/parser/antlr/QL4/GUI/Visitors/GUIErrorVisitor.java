package org.uva.sea.ql.parser.antlr.QL4.GUI.Visitors;

import javafx.scene.text.Text;

import org.uva.sea.ql.parser.antlr.QL4.Visitor;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;


/**
 * Visits QLErrorMsg and returns GUI text element
 * @author Sammie Katt
 */
public class GUIErrorVisitor extends Visitor {

	public Text visit(QLErrorMsg error) {
		return new Text(error.toString());
	}
}
