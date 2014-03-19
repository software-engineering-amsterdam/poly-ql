package ql.ast.environment;

import java.util.HashMap;
import java.util.Map;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.FormItems;
import ql.ast.type.NotDefined;
import ql.ast.type.Type;
import ql.ast.value.Value;

public class Environment {
	
	private final Map<Ident, Type> typeEnvironment;
	private final Map<Ident, Value> valueEnvironment;
	private final Map<FormItems, Environment> scopeEnvironment;
	private final Environment parentEnvironment;
	
	public Environment(Environment parentEnvironment) {
		typeEnvironment = new HashMap<Ident, Type>();
		valueEnvironment = new HashMap<Ident, Value>();
		scopeEnvironment = new HashMap<FormItems, Environment>();
		this.parentEnvironment = parentEnvironment;
	}
	
	public Environment(){
		this(null);
	}
	
	public Boolean containsType(Ident ident) {
		if (typeEnvironment.containsKey(ident))
			return true;
		else if (parentEnvironment != null && parentEnvironment.containsType(ident))
			return true;
		else 
			return false;
	}

	public Boolean containsValue(Ident ident) {
		if (valueEnvironment.containsKey(ident))
			return true;
		else if (parentEnvironment != null && parentEnvironment.containsValue(ident))
			return true;
		else 
			return false;
	}
	
	public void addType(Ident ident, Type type) {
		if (!containsType(ident)) {
			typeEnvironment.put(ident, type);
		}
	}
	
	public void addValue(Ident ident, Value value) {
		valueEnvironment.put(ident, value);
	}
	
	public Type getType(Ident ident) {
		if (typeEnvironment.containsKey(ident))
			return typeEnvironment.get(ident);
		else if (parentEnvironment != null && parentEnvironment.containsType(ident))
			return parentEnvironment.getType(ident);
		else 
			return new NotDefined();
	}
	
	public Value getValue(Ident ident) {
		assert containsValue(ident);
		if(containsValue(ident)){
			if (valueEnvironment.containsKey(ident))
				return valueEnvironment.get(ident);
			else
				return parentEnvironment.getValue(ident);
		}else 
			throw new IllegalArgumentException("The ident " + ident.getValue() + " has no value yet");
	}
	
	public Environment getParentEnvironment() {
		return parentEnvironment;
	}

	public Environment getScopeEnvironment(FormItems formItem) {
		if (!scopeEnvironment.containsKey(formItem)) {
			scopeEnvironment.put(formItem, new Environment(this));
		}

		return scopeEnvironment.get(formItem);
	}
}
