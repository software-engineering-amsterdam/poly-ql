package org.uva.sea.ql.parser.antlr.QL4.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.NullValue;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question.QuestionElement;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.DependencyGenerator;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QuestionGUIGenerator;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Helpers.EvaluatorVisitor;

import QL4.QL4Parser.QuestionStructContext;

/**
 * GUI for displaying questionair parsed from a form in QL4
 * @author Sammie Katt
 */
public class QuestionairGUI extends GUI  {

	private Map<Identifier, QuestionElement> questionMap = new HashMap<Identifier, QuestionElement>();
	private Map<Identifier, Value> valueEnvironment = new HashMap<Identifier, Value>();
	
	@Override
	public void run() {
		launch();
	}
	
	@Override
	public void start(Stage stage) {
		Pane layout = initStage(stage, "Question");
		generateQuestions();
		render(layout);
	}
	
	/**
	 * When updating with an expression, update the calculated expression
	 * TODO: calculate
	 */
	public void update(Identifier id, Expression expr) {
		// calculate
		
		update(id, new NullValue());
	}
	
	/**
	 * Updates own environment and indirectly updates the listeners of the question
	 */
	public void update(Identifier id, Value value) {
		valueEnvironment.put(id, value);
		questionMap.get(id).updateListeners(valueEnvironment);
	}
	
	/**
	 * Visit ast and set this.questions
	 */
	private void generateQuestions() {
		// visit ast and extract questions
		QuestionGUIGenerator generator = new QuestionGUIGenerator();
		List<QuestionElement> questions = generator.visit(ast);
		
		// store questions
		for (QuestionElement question : questions) {
			questionMap.put(question.getID(), question);
		}
	}
	
	/**
	 * render questions to layout
	 */
	private void render(Pane layout) {
		// generate listeners
		Map<Identifier, List<QuestionElement>> listeners = generateListeners();
		
		// generate visibility conditions
		Map<Identifier, Value> visibilityConditions = generateVisibilityConditions();
		
		
		// render questions by setting gui, listeners, visibility conditions and add to layout
		for (QuestionElement question : questionMap.values()) {
			question.setGUI(this);
			question.setListeners(listeners.get(question.getID())); 
			question.setVisibilityCondition(new NullValue()); // TODO: fix
			
			layout.getChildren().add(question.getRepresentation());
		}
	}
	
	/**
	 * Generates the listeners (map: id -> List<QuestionElement>)
	 */
	private Map<Identifier, List<QuestionElement>> generateListeners() {
		Map<Identifier, List<QuestionElement>> listenerToElements = new HashMap<Identifier, List<QuestionElement>>();
		
		// generate dependencies
		DependencyGenerator dependenciesGenerator = new DependencyGenerator();
		dependenciesGenerator.visit(ast);
		
		// extract listeners in form of identifiers
		Map<Identifier, Set<Identifier>> listenerToIdentifiers = dependenciesGenerator.recoverListeners();
		
		// populate listenerToElements: for each existing question check for listeners
		for (Identifier listened : questionMap.keySet()) {
			listenerToElements.put(listened, new ArrayList<QuestionElement>());
			if (listenerToIdentifiers.containsKey(listened)) {
				for (Identifier listener : listenerToIdentifiers.get(listened)) {
					listenerToElements.get(listened).add(questionMap.get(listener));
				}
			}
		}
		
		return listenerToElements;
	}
	
	/**
	 * Generates the visibility conditions (map: id -> value) TODO
	 */
	private Map<Identifier, Value> generateVisibilityConditions() {
		return new HashMap<Identifier, Value>();
	}
}	
