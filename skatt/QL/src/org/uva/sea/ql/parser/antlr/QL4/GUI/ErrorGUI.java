package org.uva.sea.ql.parser.antlr.QL4.GUI;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Error;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.GUIErrorVisitor;

/**
 * GUI for displaying errors created when parsing a questionair
 * @author Sammie Katt
 */
public class ErrorGUI extends GUI {

	private GUIErrorVisitor guiErrorVisitor = new GUIErrorVisitor();
	
	@Override
	public void run() {
		launch();
	}

	@Override
	public void start(Stage stage) {
		initStage(stage, "Errors");
		VBox layout = createLayout();
		render(layout);
		showStage(stage, layout);
	}
	
	/**
	 * creates and adds error GUI elements
	 */
	protected void render(VBox layout) {
		for(QLErrorMsg msg : errors) {
			Error er = new Error(guiErrorVisitor.visit(msg));
			layout.getChildren().add(er.getRepresentation());
		}
	}

}
