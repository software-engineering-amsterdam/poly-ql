package ast.visitors;

import ast.types.BoolType;
import ast.types.IntType;
import ast.types.StrType;
import ast.types.UnknownType;

public interface TypeVisitor<T> {
	T visit(BoolType node);
	T visit(IntType node);
	T visit(StrType node);
	T visit(UnknownType node);
}
