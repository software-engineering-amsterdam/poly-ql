package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import java.util.Map;

import javafx.scene.control.TextField;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.GUI.GUI;

/**
 * GUI element representing computed question in QL
 * @author Sammie Katt
 */
public class ComputedQuestionElement extends QuestionElement {

	private final Expression expr;
	
	public ComputedQuestionElement(javafx.scene.control.Label label, Type type, Identifier id, Expression expr) {
		super(label, type, id, new TextField());
		this.expr = expr;
		input.setEditable(false); // computed is not editable
	}
	
	/**
	 * Implements update: check visibility and value
	 */
	@Override
	public void update(Map<Identifier, Value> environment) {
		checkVisibility(environment); // implemented in parent as all subclasses of questionElements need this
		checkValue(environment);
	}
	
	/**
	 * checks new value
	 */
	private void checkValue(Map<Identifier, Value> environment) {
		System.err.println("ComputedQuestionElement:checkValue needs to be implemented");
		gui.update(id, expr); 
	}
}
