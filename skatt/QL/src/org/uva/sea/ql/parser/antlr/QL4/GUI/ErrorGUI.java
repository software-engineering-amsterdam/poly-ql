package org.uva.sea.ql.parser.antlr.QL4.GUI;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.uva.sea.ql.parser.antlr.QL4.GUI.Visitors.GUIErrorVisitor;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

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
			Text errorText = guiErrorVisitor.visit(msg);

			errorText.setFill(Color.RED);
			
			layout.getChildren().add(errorText);
		}
	}

}
