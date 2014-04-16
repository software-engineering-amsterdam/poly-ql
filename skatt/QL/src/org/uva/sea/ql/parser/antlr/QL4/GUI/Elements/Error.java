package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import org.uva.sea.ql.parser.antlr.QL4.GUI.GUIElement;

/**
 * Represents QL Error gui element
 * @author Sammie Katt
 *
 */
public class Error extends GUIElement{

	private Text text;
	public Error(String text) {
		this.text = new Text(text);
		this.text.setFill(Color.RED);
	}
	
	@Override
	public Node getRepresentation() {
		return text;
	}
}
