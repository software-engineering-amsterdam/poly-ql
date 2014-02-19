package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Identifier extends Expression {

	private String name;
	
	public Identifier(String name) {
		
		this.name = name;

	}
	
	public String getIdentifier(){
		return this.name;
	}
	
	public String show(){
		return name;};

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}
	
	public Type typeOf(TypeEnvironment environment){
		return environment.getType(this);
	}
	
	@Override
	public boolean equals(Object other) {
		System.out.println("Comparing...");
	    if (other instanceof Identifier) {
	        name.equals(((Identifier) other).getIdentifier());
	    }
	    
	    return false;

	}
	
	@Override
	public int hashCode(){
		return name.hashCode();
	}
	

}
