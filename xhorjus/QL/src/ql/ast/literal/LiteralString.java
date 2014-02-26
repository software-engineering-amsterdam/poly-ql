package ql.ast.literal;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.type.TypeBool;

public class LiteralString extends LiteralInterface<String> {
	public LiteralString(String str) {
		super(str);
	}
	
	@Override
	public TypeBool getType() {
		return new TypeBool();
	}
	
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}