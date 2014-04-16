package org.uva.sea.ql.parser.antlr.QL4.GUI;

import java.util.List;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question.QuestionElement;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QuestionGUIGenerator;

/**
 * GUI for displaying questionair parsed from a form in QL4
 * @author Sammie Katt
 */
public class QuestionairGUI extends GUI  {

	@Override
	public void run() {
		launch();
	}
	
	@Override
	public void start(Stage stage) {
		initStage(stage, "Question");
		VBox layout = createLayout();
		render(layout);
		showStage(stage, layout);
	}

	/**
	 * generate and render questions to layout
	 */
	private void render(VBox layout) {
		// generate questions
		QuestionGUIGenerator generator = new QuestionGUIGenerator();
		List<QuestionElement> questions = generator.visit(ast);
		
		// render questions
		for (QuestionElement question : questions) {
			layout.getChildren().add(question.getRepresentation());
		}
	}
}
