package org.uva.sea.ql.parser.antlr.QL4.GUI;

import java.util.List;
import java.util.Map;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question.QuestionElement;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QuestionGUIGenerator;

/**
 * GUI for displaying questionair parsed from a form in QL4
 * @author Sammie Katt
 */
public class QuestionairGUI extends GUI  {

	private Map<Identifier, QuestionElement> questions = null;
	
	@Override
	public void run() {
		launch();
	}
	
	@Override
	public void start(Stage stage) {
		Pane layout = initStage(stage, "Question");
		render(layout);
	}

	/**
	 * Updates visibility 
	 */
	public void updateVisibility(Identifier id, Boolean visibility) {
		questions.get(id).updateVisibility(visibility);
	}
	
	/**
	 * Updates value of question element
	 */
	public void updateValue(Identifier id , Value val) {
		questions.get(id).updateValue(val);
	}
	
	/**
	 * generate and render questions to layout
	 */
	private void render(Pane layout) {
		// generate questions
		QuestionGUIGenerator generator = new QuestionGUIGenerator();
		List<QuestionElement> questions = generator.visit(ast);
		
		// render questions
		for (QuestionElement question : questions) {
			layout.getChildren().add(question.getRepresentation());
		}
	}
	
	/**
	 * Setters
	 */
	public void setQuestions(Map<Identifier, QuestionElement> questions) {
		this.questions = questions;
	}
}
