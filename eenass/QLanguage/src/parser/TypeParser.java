package parser;

import ast.types.BoolType;
import ast.types.IntType;
import ast.types.StrType;
import ast.types.UnknownType;
import ast.visitors.TypeVisitor;

public class TypeParser implements TypeVisitor<String>{

	public TypeParser() {
	}

	@Override
	public String visit(BoolType node) {
		return "boolean";
	}

	@Override
	public String visit(IntType node) {
		return "integer";
	}

	@Override
	public String visit(StrType node) {
		return "string";
	}

	@Override
	public String visit(UnknownType node) {
		return "unknowntype";
	}

}
