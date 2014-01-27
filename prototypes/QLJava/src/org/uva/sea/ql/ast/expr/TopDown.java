package org.uva.sea.ql.ast.expr;

public class TopDown implements Visitor<Void> {
	private Void visitBinary(Binary exp) {
		exp.getLhs().accept(this);
		exp.getRhs().accept(this);
		return null;
	}

	private Void visitUnary(Unary exp) {
		exp.getArg().accept(this);
		return null;
	}

	
	@Override
	public Void visit(Add ast) { return visitBinary(ast); }

	@Override
	public Void visit(Mul ast) { return visitBinary(ast); }

	@Override
	public Void visit(Div ast) { return visitBinary(ast); }

	@Override
	public Void visit(Sub ast) { return visitBinary(ast); }

	@Override
	public Void visit(NEq ast) { return visitBinary(ast); }

	@Override
	public Void visit(LEq ast) { return visitBinary(ast); }

	@Override
	public Void visit(GEq ast) { return visitBinary(ast); }

	@Override
	public Void visit(LT ast) { return visitBinary(ast); }

	@Override
	public Void visit(GT ast) { return visitBinary(ast); }

	@Override
	public Void visit(Eq ast) { return visitBinary(ast); }

	@Override
	public Void visit(And ast) { return visitBinary(ast); }

	@Override
	public Void visit(Or ast) { return visitBinary(ast); }

	@Override
	public Void visit(Not ast) { return visitUnary(ast); }

	@Override
	public Void visit(Neg ast) { return visitUnary(ast); }

	@Override
	public Void visit(Pos ast) { return visitUnary(ast); }

	@Override
	public Void visit(Int ast) { return null; }

	@Override
	public Void visit(Bool ast) { return null; }

	@Override
	public Void visit(Str ast) { return null; }

	@Override
	public Void visit(Ident ast) { return null; }

}