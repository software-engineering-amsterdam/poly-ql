package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Abstract parent class of question GUI elements representing (computed) questions in QL 
 * @author Sammie Katt
 */
public abstract class QuestionElement {

	protected Identifier id;
	protected Label label;
	protected Node input;
	protected Type type;
	
	public QuestionElement(Label label, Type type, Identifier id, Node input) {
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
}
