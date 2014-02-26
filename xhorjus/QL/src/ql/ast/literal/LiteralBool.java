package ql.ast.literal;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.type.TypeBool;

/**
 * Bool literal class 
 */
public class LiteralBool extends LiteralInterface<Boolean> {
	public LiteralBool(Boolean truth) {
		super(truth);
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