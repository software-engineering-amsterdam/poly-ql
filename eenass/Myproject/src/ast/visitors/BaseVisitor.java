package ast.visitors;

import ast.ASTNode;
import ast.Visitor;
import ast.expr.Identifier;
import ast.expr.binExpr.Add;
import ast.expr.binExpr.And;
import ast.expr.binExpr.Div;
import ast.expr.binExpr.Eq;
import ast.expr.binExpr.GEq;
import ast.expr.binExpr.GT;
import ast.expr.binExpr.LEq;
import ast.expr.binExpr.LT;
import ast.expr.binExpr.Mul;
import ast.expr.binExpr.NEq;
import ast.expr.binExpr.Or;
import ast.expr.binExpr.Sub;
import ast.expr.literal.BoolLiteral;
import ast.expr.literal.IntLiteral;
import ast.expr.literal.StrLiteral;
import ast.expr.types.BoolType;
import ast.expr.types.IntType;
import ast.expr.types.StrType;
import ast.expr.types.Type;
import ast.expr.unExpression.Neg;
import ast.expr.unExpression.Not;
import ast.expr.unExpression.Pos;
import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.StatementList;

public class BaseVisitor implements Visitor<String> {

	public BaseVisitor(){
	}

	@Override
	public String visit(Pos node) {
		return "+ " + node.getOperand().accept(this);
	}

	@Override
	public String visit(Neg node) {
		return "- " + node.getOperand().accept(this);
	}

	@Override
	public String visit(Not node) {
		return "! " + node.getOperand().accept(this);
	}

	@Override
	public String visit(Add node) {
		return "(" + node.get_lhs().accept(this) + " + " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(And node) {
		return "(" + node.get_lhs().accept(this) + " && " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(Div node) {
		return "(" + node.get_lhs().accept(this) + " / " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(Eq node) {
		return "(" + node.get_lhs().accept(this) + " == " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(GEq node) {
		return "(" + node.get_lhs().accept(this) + " >= " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(GT node) {
		return "(" + node.get_lhs().accept(this) + " > " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(LEq node) {
		return "(" + node.get_lhs().accept(this) + " <= " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(LT node) {
		return "(" + node.get_lhs().accept(this) + " < " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(Mul node) {
		return "(" + node.get_lhs().accept(this) + " * " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(NEq node) {
		return "(" + node.get_lhs().accept(this) + " != " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(Or node) {
		return "(" + node.get_lhs().accept(this) + " || " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(Sub node) {
		return "(" + node.get_lhs().accept(this) + " - " + node.get_rhs().accept(this) + ")";
	}

	@Override
	public String visit(BoolLiteral node) {
		return Boolean.toString(node.getVal());
	}

	@Override
	public String visit(Identifier node) {
		return node.getIdentName();
	}

	@Override
	public String visit(IntLiteral node) {
		return Integer.toString(node.getVal());
	}

	@Override
	public String visit(StrLiteral node) {
		return node.getVal();
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
	public String visit(StatementList node) {
		String str= "";
		for (ASTNode e : node.getList()) {
			str += e.accept(this) + "\n";
		}
		return str;
	}

	@Override
	public String visit(Question node) {
		return node.getId().accept(this) + ":" + node.getLabel().accept(this)+ " " + visit(node.getType());
	}

	private String visit(Type type) {
		if (type.isCompatibleToBool()) return visit((BoolType)type);
		else if (type.isCompatibleToStr()) return visit((StrType)type);
		else if (type.isCompatibleToInt()) return visit((IntType)type);
		else return "unknown";
	}

	@Override
	public String visit(ComputedQuestion node) {
		return node.getId().accept(this) + ":" + node.getLabel().getVal()+ " " + visit(node.getType()) + node.getExpr().accept(this);
	}

	@Override
	public String visit(Block node) {
		return (visit(node.getStatements()));
	}

	@Override
	public String visit(IfStatement node) {
		return "if " + node.getExpr().accept(this) + "{\n" + visit(node.getStatements()) +"}";
	}

	@Override
	public String visit(Form node) {
		String str = node.getId().accept(this) + "{\n" + node.getStatements().accept(this) + "}";
		return str;
	}

	@Override
	public String visit(IfelseStatement node){
		return "\nif " + node.getExpr().accept(this) + "{\n" + visit(node.getStatements()) + "}\nelse{\n" + visit(node.getElseStatements()) + "}";
	}

}
