package ql.ast.literal;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.type.TypeMoney;

/** 
 * Int literal class 
 */
public class LiteralInt extends LiteralInterface<Integer> {
	public LiteralInt(Integer n) {
		super(n);
	}
	
	@Override
	public TypeMoney getType() {
		return new TypeMoney();
	}
	
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}