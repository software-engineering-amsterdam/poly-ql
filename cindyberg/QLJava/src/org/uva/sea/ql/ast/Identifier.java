package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Identifier extends Expression {

	private final String name;
	
	public Identifier(String name) {	
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return name;};

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type typeOf(TypeEnvironment environment){
		assert (environment.isDeclared(this));
		return environment.ofType(this);
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other instanceof Identifier) {
	        return name.equals(((Identifier) other).getName());
	    } 
	    return false;
	}
	
	@Override
	public int hashCode(){
		return name.hashCode();
	}
	

}
