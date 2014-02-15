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
	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}

}
