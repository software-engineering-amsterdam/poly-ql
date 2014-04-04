package ql.ast.visitor;

import java.util.List;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.literals.Bool;
import ql.ast.node.literals.Int;
import ql.ast.node.literals.Str;
import ql.ast.node.syntactic.Label;
import ql.ast.node.syntactic.Statement;
import ql.ast.node.types.BoolType;
import ql.ast.node.types.IntType;
import ql.ast.node.types.StringType;
import ql.ast.node.types.Type;

public abstract class ASTVisitor {
	public void visit(Ident ident) {}

	public void visit(Expression operand) {
		operand.accept(this);
	}

	public void visit( Expression leftHandOperand, Expression rightHandOperand) {
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}	

	public void visit(Bool bool) {}
	public void visit(Int int1) {}
	public void visit(Str str) {}

	public void visit(BoolType bool) {}
	public void visit(IntType intType) {}
	public void visit(StringType stringType) {}

	public void visit(Ident ident, List<Statement> list) {
		for(Statement s : list)
			s.accept(this);
	}

	public void visit(Expression condition, List<Statement> thenStatements) {
		condition.accept(this);
		for(Statement s : thenStatements)
			s.accept(this);
	}

	public void visit(Expression condition, List<Statement> thenStatements,
			List<Statement> elseStatements) {
		condition.accept(this);
		for(Statement s : thenStatements)
			s.accept(this);
		for(Statement s : elseStatements)
			s.accept(this);
	}

	public void visit(Ident ident, Label label, Type type) {
		ident.accept(this);
		label.accept(this);
		type.accept(this);
	}

	public void visit(Ident ident, Label label, Type type, Expression expr) {
		ident.accept(this);
		label.accept(this);
		type.accept(this);
		expr.accept(this);
	}

	public void visit(Label label) {}
}
