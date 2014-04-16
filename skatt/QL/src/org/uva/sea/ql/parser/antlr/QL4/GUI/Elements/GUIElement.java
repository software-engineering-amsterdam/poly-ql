package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements;

import javafx.scene.Node;

/**
 * Abstract parent of all QL gui elements
 * @author Sammie Katt
 */
public abstract class GUIElement {

	/**
	 * Setter & getters to overwrite
	 */
	public Node getRepresentation() {
		throw new UnsupportedOperationException();
	}
}
