package org.uva.sea.ql.typechecker;

import java.util.HashMap;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.NullType;
import org.uva.sea.ql.ast.type.Type;

public class TypeEnvironment {

	private HashMap<Identifier, Type> types = new HashMap<Identifier,Type>();
	
	public Boolean isDeclared(Identifier id){
		return types.containsKey(id);
	}
	
	public Type getType(Identifier id){
		
		if(isDeclared(id))
		{
			return types.get(id);
		}
		return new NullType();
	}
	
	public void addIdentifier(Identifier id, Type type){
		types.put(id,type);
	}
	
	public HashMap<Identifier,Type> getEnvironment(){
		return types;
	}
}
