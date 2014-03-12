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
	
	public void addObserver(Identifier id, Observer obs){
		observables.get(id).addObserver(obs);
	}
	
	public void putObserver(Identifier id, Observable obs){
		observables.put(id, obs);
	}

	public Map<Identifier, Value> getEnvValues() {
		return env;
	}

}
