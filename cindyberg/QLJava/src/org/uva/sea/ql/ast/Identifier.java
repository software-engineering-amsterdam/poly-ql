package org.uva.sea.ql.ast;

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
	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}

}
