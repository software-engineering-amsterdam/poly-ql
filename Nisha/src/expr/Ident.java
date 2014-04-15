package expr;

import java.util.Map;

import ast.Visitor;
import ast.type.Type;

public class Ident extends Expr{
	public final String id;

	public Ident(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	
	@Override
	public Type typeof(Map<Ident,Type> identifier) {
		for (Ident key: identifier.keySet()){
			if(this.id.equals(key.id))
			{
			return identifier.get(key);
		}
		}
		return null;
	}
	
}
