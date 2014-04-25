package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Abstract parent class of question GUI elements representing (computed) questions in QL 
 * @author Sammie Katt
 */
public abstract class QuestionElement {

	final protected Identifier id;
	
	// graphical properties
	final protected Label label;
	protected TextInputControl input;
	final protected Type type;
	
	public QuestionElement(Label label, Type type, Identifier id, TextInputControl input) {
		this.id = id;
		this.type = type;
		this.label = label;
		this.input = input;
	}
	
	/**
	 * GUI print
	 */
	public Node getRepresentation() {
		HBox hbx = new HBox();
		hbx.getChildren().add(label);
		hbx.getChildren().add(input);
		
		return hbx;
	}

}
