package org.uva.sea.ql.parser.antlr.QL4.GUI;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.ErrorElement;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

/**
 * GUI for displaying errors created when parsing a questionair
 * @author Sammie Katt
 */
public class ErrorGUI extends GUI {

	@Override
	public void run() {
		launch();
	}

	@Override
	public void start(Stage stage) {
		Pane layout = initStage(stage, "Errors");
		
		render(layout);
	}
	
	/**
	 * creates and adds error GUI elements
	 */
	private void render(Pane layout) {
		for(QLErrorMsg msg : errors) {
			ErrorElement er = new ErrorElement(msg.toString());
			layout.getChildren().add(er.getRepresentation());
		}
	}
	
	/**
	 * Updating visbility or value does nothing
	 */
	public void updateVisibility(Identifier id, Boolean visibility) {}
	public void updateValue(Identifier id , Value val) {}


}
