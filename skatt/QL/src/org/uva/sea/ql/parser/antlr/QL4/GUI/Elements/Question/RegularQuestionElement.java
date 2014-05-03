package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import java.util.Map;

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
	 * Implement on update: check for visibility
	 */
	@Override
	public void update(Map<Identifier, Value> environment) {
		checkVisibility(environment); // implemented in parent: used in all question element subclasses
	}
}
