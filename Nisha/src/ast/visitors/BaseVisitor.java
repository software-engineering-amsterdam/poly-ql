package ast.visitors;

import ast.ASTNode;
import ast.Visitor;
import ast.form.Block;
import ast.form.Computedquest;
import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Question;
import ast.form.StatementList;
import ast.literals.BoolLiteral;
import ast.literals.IntLiteral;
import ast.literals.StrLiteral;
import ast.type.Booltype;
import ast.type.Inttype;
import ast.type.Strtype;
import ast.type.Type;
import expr.Ident;
import expr.conditional.And;
import expr.conditional.Or;
import expr.operation.Add;
import expr.operation.Div;
import expr.operation.Mul;
import expr.operation.Sub;
import expr.relational.Eq;
import expr.relational.GEq;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;
import expr.relational.NEq;
import expr.unary.Neg;
import expr.unary.Not;
import expr.unary.Pos;

public class BaseVisitor implements Visitor<String> {

	public BaseVisitor() {
	}

	@Override
	public String visit(And node) {
		return "(" + node.getLhs().accept(this) + "&&" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Or node) {
		return "(" + node.getLhs().accept(this) + "||" + node.getRhs().accept(this) + ")";
	}


	@Override
	public String visit(Ident node) {
		return node.getId();
	}

	@Override
	public String visit(Form node) {
		String str = "form" + " " + node.getId().accept(this) + "{\n" + node.getStatements().accept(this) + "}";
		return str;
	}

	@Override
	public String visit(Question node) {
		return node.getId().accept(this) + ":" + node.getStatement().getValue()+ " " + 	visit(node.getType()) ;
	}

	@Override
	public String visit(IfElse node) {
		return "\nif " + node.getExpr().accept(this) + "{\n" + visit(node.getStatements()) + "}\nelse{\n" + visit(node.getStatement1()) + "}" ;
	}

	@Override
	public String visit(Ifstate node) {
		return "if" + node.getExpr().accept(this)+ "{\n"+ visit(node.getStatements()) + "}";
	}


	@Override
	public String visit(Add node) {
		return "(" + node.getLhs().accept(this) + "+" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Div node) {
		return "(" + node.getLhs().accept(this) + "/" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Mul node) {
		return "(" + node.getLhs().accept(this) + "*" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Sub node) {
		return "(" + node.getLhs().accept(this) + "-" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Eq node) {
		return "(" + node.getLhs().accept(this) + "==" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(GEq node) {
		return "(" + node.getLhs().accept(this) + ">=" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(GT node) {
		return "(" + node.getLhs().accept(this) + ">" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(LEq node) {
		return "(" + node.getLhs().accept(this) + "<=" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(LT node) {
		return "(" + node.getLhs().accept(this) + "<" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(NEq node) {
		return "(" + node.getLhs().accept(this) + "!=" + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Booltype node) {
		return "boolean";
	}

	@Override
	public String visit(Inttype node) {
		return "integer";
	}

	
	private String visit(Type node) {
		if (node.isBool()) return visit((Booltype) node);
		else if (node.isStr()) return visit((Strtype)node);
		else if (node.isInt()) return visit((Inttype)node);
		else return "unknown";
	}

	@Override
	public String visit(Strtype node) {
		return "string";
	}

	@Override
	public String visit(Neg node) {
		return "-" + node.getOperand().accept(this);
	}

	@Override
	public String visit(Not node) {
		return "!" + node.getOperand().accept(this);
	}

	@Override
	public String visit(Pos node) {
		return "+" + node.getOperand().accept(this);
	}


	@Override
	public String visit(StatementList statementList) {
		String str= "";
		for (ASTNode a: statementList.getList()) {
			str += a.accept(this) + "\n";
		}
		return str;
	}

	@Override
	public String visit(Computedquest node) {
		return node.getId().accept(this) + ":" + node.getStatement().getValue()+ " " + 	visit(node.getType()) + node.getExpr().accept(this);
	}

	@Override
	public String visit(BoolLiteral node) {
		return Boolean.toString(node.getValue());
	}

	@Override
	public String visit(IntLiteral node) {
		return Integer.toString(node.getValue());
	}

	@Override
	public String visit(StrLiteral node) {
		return node.getValue();
	}

	@Override
	public String visit(Block block) {
		return (visit(block.getStatements()));
	}

}
