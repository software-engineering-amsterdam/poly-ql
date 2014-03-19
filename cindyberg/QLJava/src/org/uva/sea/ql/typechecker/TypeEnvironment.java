package org.uva.sea.ql.typechecker;

import java.util.HashMap;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.MissingType;
import org.uva.sea.ql.ast.type.Type;

public class TypeEnvironment {

	private final HashMap<Identifier, Type> types = new HashMap<Identifier,Type>();
	
	public Boolean isDeclared(Identifier id){
		return types.containsKey(id);
	}
	
	public Type ofType(Identifier id){	
		if(isDeclared(id)){
			return types.get(id);
		}
		return new MissingType();
	}
	
	public void declareIdentifier(Identifier id, Type type){
		types.put(id,type);
	}
}
