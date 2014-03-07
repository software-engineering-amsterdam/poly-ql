package ql.ast.literal;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.type.TypeString;

/**
 * String literal class
 */
public class LiteralString extends LiteralInterface<String> {
	/* Constructor */
	public LiteralString(String str) {
		super(str);
	}
	
	/* Return type */
	@Override
	public TypeString getType() {
		return new TypeString();
	}
	
	/* Accept visit */
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}