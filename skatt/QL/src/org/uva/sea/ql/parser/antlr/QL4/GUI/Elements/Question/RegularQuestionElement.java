package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import javafx.scene.control.TextField;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;

/**
 * GUI element presenting a regular question in QL 
 * @author Sammie Katt
 */
public class RegularQuestionElement extends QuestionElement {

	public RegularQuestionElement(javafx.scene.control.Label label, Type type,
			Identifier id) {
		super(label, type, id, new TextField());
	}
	
	/**
	 * Sets value (does nothing, as impossible for regular question)
	 */
	@Override
	public void updateValue(Value val) {
		
	}

}
