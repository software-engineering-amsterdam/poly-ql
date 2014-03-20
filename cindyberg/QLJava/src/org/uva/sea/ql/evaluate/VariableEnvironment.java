package org.uva.sea.ql.evaluate;

import java.util.HashMap;

import org.uva.sea.ql.ast.Identifier;

public class VariableEnvironment {

	private final HashMap<Identifier,Value> variables = new HashMap<Identifier,Value>();
	
	public Boolean isDeclared(Identifier id){
		return variables.containsKey(id);
	}
	
	public Value getValue(Identifier id){	
		if(isDeclared(id)){
			return variables.get(id);
		}
		
		return new UndefinedValue();
	}
	
	public void addIdentifier(Identifier id, Value value){
		variables.put(id,value);
	}
	
	public HashMap<Identifier,Value> getEnvironment(){
		return variables;
	}
}

