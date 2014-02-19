package org.uva.sea.ql.typechecker;

import java.util.HashMap;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.*;

public class Environment {

	private HashMap<Identifier, Type> types = new HashMap<Identifier,Type>();
	
	public Boolean isDeclared(Identifier id){
	
		return(types.containsKey(id));
	}
	
	public Type getType(Identifier id){
		
		return(types.get(id));
	}
	
	public void addIdentifier(Identifier id, Type type){
		
		types.put(id,type);
	}
}
