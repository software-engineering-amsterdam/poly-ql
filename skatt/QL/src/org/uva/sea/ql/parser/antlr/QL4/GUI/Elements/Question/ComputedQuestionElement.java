package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import javafx.scene.control.TextField;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;

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
	
	/**
	 * Sets value of text
	 */
	@Override
	public void updateValue(Value val) {
		input.setText(val.toString());
	}
}
