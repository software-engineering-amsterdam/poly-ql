package gui.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import ast.expr.Identifier;
import ast.value.Value;

public class State {
	
	private final Map<Identifier, Value> env;
	private Map<Identifier, Observable> observables;

	public State() {
		this.env = new HashMap<Identifier, Value>();
		this.observables = new HashMap<Identifier, Observable>();
	}
	
	public State(Map<Identifier, Value> env, Map<Identifier, Observable> observables) {
		this.env = env;
		this.observables = observables;
	}
	
	public void addAllObservers(Observer obs){
		for (Identifier ident: observables.keySet()){
			observables.get(ident).addObserver(obs);
		}
	}

	public void putObserver(Identifier id, Observable obs){
		observables.put(id, obs);
	}

	public void addValue(Identifier id, Value val){
		this.env.put(id, val);
		notify(id);
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
