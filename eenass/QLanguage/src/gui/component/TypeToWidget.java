package gui.component;

import ast.types.BoolType;
import ast.types.IntType;
import ast.types.StrType;
import ast.types.UnknownType;
import ast.visitors.TypeVisitor;


public class TypeToWidget implements TypeVisitor<Widget> {	

	@Override
	public Widget visit(BoolType node) {
		return new CheckBox();
	}

	@Override
	public Widget visit(IntType node) {
		return new IntTextField();
	}

	@Override
	public Widget visit(StrType node) {
		return new StrTextField();
	}

	@Override
	public Widget visit(UnknownType node) {
		throw new UnsupportedOperationException();
	}
	
}
