package parser;

import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.Statement;
import ast.statement.StatementList;
import ast.visitors.StatementVisitor;

public class StatementParser implements StatementVisitor<String>{
	
	private ExprParser exprParser = new ExprParser();
	private TypeParser typeParser = new TypeParser();

	public StatementParser() {
	}

	
	@Override
	public String visit(StatementList node) {
		String str= "";
		for (Statement e : node.getList()) {
			str += e.accept(this) + "\n";
		}
		return str;
	}

	@Override
	public String visit(Question node) {
		return node.getId().accept(exprParser) + ":" + node.getLabel().accept(exprParser)+ " " + node.getType().accept(typeParser);
	}

	@Override
	public String visit(ComputedQuestion node) {
		return node.getId().accept(exprParser) + ":" + node.getLabel().accept(exprParser)+ " " + node.getType().accept(typeParser) + " "+ node.getExpr().accept(exprParser);
	}

	@Override
	public String visit(Block node) {
		return (visit(node.getStatements()));
	}

	@Override
	public String visit(IfStatement node) {
		return "if " + node.getExpr().accept(exprParser) + "{\n" + visit(node.getStatements()) +"}";
	}

	@Override
	public String visit(Form node) {
		String str = "form " + node.getId().accept(exprParser) + "{\n" + node.getStatements().accept(this) + "}";
		return str;
	}

	@Override
	public String visit(IfelseStatement node){
		return "\nif " + node.getExpr().accept(exprParser) + "{\n" + visit(node.getStatements()) + "}\nelse{\n" + visit(node.getElseStatements()) + "}";
	}

}
