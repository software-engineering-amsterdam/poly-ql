package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;

/**
 * Abstract parent class of question GUI elements representing (computed) questions in QL 
 * @author Sammie Katt
 */
public abstract class QuestionElement {

	protected Identifier id;
	protected Label label;
	protected TextInputControl input;
	protected Type type;
	
	public QuestionElement(Label label, Type type, Identifier id, TextInputControl input) {
		this.id = id;
		this.label = label;
		this.id = id;
		this.input = input;
	}
	
	public Node getRepresentation() {
		HBox hbx = new HBox();
		hbx.getChildren().add(label);
		hbx.getChildren().add(input);
		
		return hbx;
	}

	/**
	 * Sets visibility of both elements in question
	 */
	public void updateVisibility(Boolean visibility) {
		label.setVisible(visibility);
		input.setVisible(visibility);		
	}

	/**
	 * Sets value of input, to be overridden
	 */
	public void updateValue(Value val) {
		throw new UnsupportedOperationException();
		
	}
}
