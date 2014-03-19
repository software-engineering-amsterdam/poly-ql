package org.uva.sea.ql.gui.widget;

import java.util.Observable;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.questionaire.State;

public abstract class Widget extends Observable {

	private Identifier identifier;
	private State state;
	
	public Widget(Identifier identifier, State state) {
		this.identifier = identifier;
		this.state = state;
	}

	public abstract JComponent UIElement();

	public abstract void setEnabled(boolean isEnabled);

	public abstract void setValue(Value value);
	
	public Value getValue(Identifier id){
		return state.getEnvironment().getValue(id);
	}
	
	public State getState(){
		return state;
	}
	
	public Identifier getIdentifier(){
		return identifier;
	}
}
