package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import javafx.scene.control.TextField;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * GUI element representing computed question in QL
 * @author Sammie Katt
 */
public class ComputedQuestionElement extends QuestionElement {

	public ComputedQuestionElement(javafx.scene.control.Label label, Type type,
			Identifier id) {
		super(label, type, id, new TextField());
		input.setEditable(false); // computed is not editable
	}
}
