package gui.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import ast.expr.Identifier;
import ast.expr.evaluate.Value;

public class State {
	
	private final Map<Identifier, Value> env;
	private final Map<Identifier, Observable> observables;

	public State() {
		this.env = new HashMap<Identifier, Value>();
		this.observables = new HashMap<Identifier, Observable>();
	}
	
	public State(Map<Identifier, Value> env, Map<Identifier, Observable> observables) {
		this.env = env;
		this.observables = observables;
	}
	
	public void addObservers(Identifier id, Observer obs){
		observables.get(id).addObserver(obs);
	}
	
	public void putValue(Identifier id, Value val){
		env.put(id, val);
	}
	
	public void putObserver(Identifier id, Observable obs){
		observables.put(id, obs);
	}

	public Map<Identifier, Value> getEnvValues() {
		return env;
	}
	
	public Map<Identifier, Observable> getobservables() {
		return observables;
	}
	
	public void notify(Identifier ident){
		Observable obs = observables.get(ident);
		if (obs != null){
			obs.notifyObservers();
		}
	}

	public void notifyall(){
		observables.notifyAll();
	}
	
	public State currentState(){
		return new State(env, observables);
	}
}
