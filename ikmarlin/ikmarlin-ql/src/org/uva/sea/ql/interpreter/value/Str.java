package org.uva.sea.ql.interpreter.value;

import org.uva.sea.ql.ast.type.Type;


public class Str extends Value<String> {
	
	public Str(){
		this.value = "";
	}
	
	public Str(String value){
		this.value = value;
	}

	@Override
	public Value<?> parse(Type type) {
		return type.hasValue().parse(this);
	}
	
	@Override
	protected Value<?> parse(Str value) {
		return value;
	}

	@Override
	protected Value<?> parse(Undefined value) {
		return new Str();
	}

}
