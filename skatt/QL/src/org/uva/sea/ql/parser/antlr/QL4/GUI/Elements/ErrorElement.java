package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


/**
 * Represents QL Error gui element
 * @author Sammie Katt
 *
 */
public class ErrorElement extends GUIElement{

	private Text text;
	public ErrorElement(String text) {
		this.text = new Text(text);
		this.text.setFill(Color.RED);
	}
	
	@Override
	public Node getRepresentation() {
		return text;
	}
}
