package org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.NullValue;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.GUI.QuestionairGUI;

/**
 * Abstract parent class of question GUI elements representing (computed) questions in QL 
 * @author Sammie Katt
 */
public abstract class QuestionElement {

	final protected Identifier id;
	
	// graphical properties
	final protected Label label;
	final protected TextInputControl input;
	final protected Type type;
	
	// behavior 
	protected QuestionairGUI gui;
	private Value visibilityCondition = new Bool("true");
	private List<QuestionElement> listeners = new ArrayList<QuestionElement>();
	
	public QuestionElement(Label label, Type type, Identifier id, TextInputControl input) {
		this.id = id;
		this.type = type;
		this.label = label;
		this.input = input;
	}
	
	/**
	 * GUI print
	 */
	public Node getRepresentation() {
		HBox hbx = new HBox();
		hbx.getChildren().add(label);
		hbx.getChildren().add(input);
		
		return hbx;
	}
	
	/**
	 * If observed pushes update, check for visibility / value: to be implemented in subclass
	 */
	public void update(Map<Identifier, Value> environment) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * checks for visibility
	 */
	protected void checkVisibility(Map<Identifier, Value> environment) {
		System.err.println("QuestionElement:checkVisibility needs to be implemented");
	}
	
	/**
	 * On change, notify listeners
	 */
	private void setupListeners() {
		input.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean arg1, Boolean arg2) {
				if (arg2) {
					gui.update(getID(), getValue());
				}
			}
		});
	}

	/**
	 * Notify listeners
	 */
	public void updateListeners(Map<Identifier, Value> environment) {
		System.out.println("QuestionElement:updateListeners called");
		for(QuestionElement q : listeners) {
			q.update(environment);
		}
	}

	/////  Setters & getters
	
	public void setVisibilityCondition(Value visibilityCondition) {
		this.visibilityCondition = visibilityCondition;
	}

	/**
	 * Additionally calls 'setupListeners'
	 */
	public void setListeners(List<QuestionElement> listeners) {
		this.listeners = listeners;
		setupListeners();
	}
	
	public void setGUI(QuestionairGUI gui) {
		this.gui = gui;
	}

	public Identifier getID() {
		return this.id;
	}	
	
	/**
	 * To be implemented by subclass TODO: throw exception
	 */
	public Value getValue() {
		System.err.println("QuestionElement:getValue unsupported");
		// throw new UnsupportedOperationException();
		return new NullValue();
	}
	
	@Override
	public String toString() {
		return "question " + id;
	}
	
}
