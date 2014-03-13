package org.uva.sea.ql.gui.questionaire;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.evaluate.VariableEnvironment;

public class State {

	private VariableEnvironment environment;
	private HashMap<Identifier, Observable> observables;
	
	public State(){
		this.environment =  new VariableEnvironment();
		this.observables = new HashMap<Identifier,Observable>();		
	}
	
	public void addObserver(Identifier identifier, Observer observer){
		observables.get(identifier).addObserver(observer);	
	}
	
	public void putVariable(Identifier identifier, Value value){
		environment.addIdentifier(identifier, value);
	}

	public void putObservable(Identifier identifier, Observable observable) {
		observables.put(identifier, observable);		
	}

	public VariableEnvironment getEnvironment() {
		return environment;
	}

	public void notify(Identifier identifier) {
		Observable observable = observables.get(identifier);
		if (observables != null) {
			observable.notifyObservers();
		}
	}

	public void addGlobalObservers(Observer observer) {
		for(Identifier id : observables.keySet()) {
			addObserver(id, observer);
		}
		
	}
}
