package org.uva.sea.ql.ast.type;

public interface ITypeVisitor {

	void visit(BoolType booltype);
	void visit(IntType inttype);
	void visit(MoneyType moneytype);
	void visit(StringType stringtype);
}
