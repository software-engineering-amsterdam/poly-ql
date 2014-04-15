package gui.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import expr.Ident;
import ast.evaluate.Value;

public class State {

	private final Map<String, Value> env;
	private Map<Ident, Observable> observables;

	public State() {
		this.env = new HashMap<String, Value>();
		this.observables = new HashMap<Ident, Observable>();
	}

	public State(Map<String, Value> env, Map<Ident, Observable> observables) {
		this.env = env;
		this.observables = observables;
	}

	public void addAllObservers(Observer obs){
		for (Ident ident: observables.keySet()){
			observables.get(ident).addObserver(obs);
		}
	}

	public void putObserver(Ident id, Observable obs){
		//System.out.println("obs "+ obs);
		observables.put(id, obs);
	}

	public void addValue(Ident id, Value val){
		this.env.put(id.id, val);
		notify(id);
	}
	public Map<String, Value> getEnvValues() {
		//System.out.println("env " + env);
		return env;
	}

	public Map<Ident, Observable> getobservables() {
		return observables;
	}

	public void notify(Ident ident){
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