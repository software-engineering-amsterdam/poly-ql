package org.uva.sea.ql.ast.expr;

import java.util.HashMap;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Undefined;
import org.uva.sea.ql.checker.ExprVisitor;

public class Ident extends Expr {
	private String name;
	
	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType(HashMap<String, Type> symbolTable) {
		if(symbolTable.containsKey(getName())){
			return symbolTable.get(getName());
		}else{
			return hasType();
		}
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> ev){
		return ev.visit(this);
	}
	
	@Override
	public String toString(){
		return getName();
	}

	@Override
	public Type hasType() {
		return new Undefined();
	}

}
