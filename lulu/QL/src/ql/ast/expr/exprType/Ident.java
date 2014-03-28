package ql.ast.expr.exprType;

import java.util.ArrayList;
import java.util.List;

import ql.ast.environment.Environment;
import ql.ast.message.Error;
import ql.ast.type.Type;
import ql.ast.value.Value;

public class Ident extends Expr{
	public final String id;
	
	public Ident(String id){
		this.id = id;
	}

	public String getValue(){
		return id;
	}
	
	@Override
	public Value eval(Environment environment) {
		if (environment.containsValue(this)) {
			return environment.getValue(this);
		}
		
		else return getType(environment).getDefaultValue();
	}
	
	@Override
	public Type getType(Environment environment) {
		if (environment.containsType(this)) {
			return environment.getType(this);
		}
		
		else return null;
	}

	@Override
	public List<Error> checkType(Environment environment) {
		List<Error> errors = new ArrayList<Error>();
		if (!environment.containsType(this)) {
			errors.add(new Error("Ident " + id + " does not exist"));
		}
		
		return errors;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ident))
			return false;
		else return id.equals(((Ident)obj).id);
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
