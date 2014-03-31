package typecheck;

import java.util.ArrayList;
import java.util.List;

import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.literal.StrLiteral;
import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.Statement;
import ast.statement.StatementList;
import ast.types.Type;
import ast.visitors.StatementVisitor;

public class StatementTypeChecker implements StatementVisitor<Boolean>{

	private final SymbolTable symb_map;
	private ErrorList errors;
	private List<StrLiteral> labels;
	
	public StatementTypeChecker(SymbolTable symb_map, ErrorList errors) {
		this.symb_map = symb_map;
		this.errors = errors;
		labels = new ArrayList<StrLiteral>();
	}
	
	public String get_errorList(){
		return errors.toString();
	}
	
	private void checkLabel(StrLiteral label) {
		if(labels.contains(label)){
			errors.addWarning("Warning: Duplicate label at " + label.getVal()); 
		}
		labels.add(label);		
	}

	@Override
	public Boolean visit(StatementList node) {
		boolean result = true;
		for(Statement s: node.getList()){
			if(!s.accept(this)){
				result = false;
			}
		}
		return result;
	}

	@Override
	public Boolean visit(Question node) {
		checkLabel(node.getLabel());
		return putIdentifier(node.getId(), node.getType());
	}
	
	private boolean putIdentifier(Identifier id, Type type){
		if(symb_map.containsSymbol(id) && (symb_map.getType(id)).isCompatibleTo(type)){
			errors.addError("Error: Invalid identifier (already used) " + id.getIdentName());
			return false;
		}
		else if(symb_map.containsSymbol(id) && !(symb_map.getType(id).isCompatibleTo(type))){
			errors.addError("Error: Identifier already used with another type " + id.getIdentName());
			return false;
		}
		symb_map.put(id, type);
		return true;		
	}

	@Override
	public Boolean visit(ComputedQuestion node) {
		boolean validId = putIdentifier(node.getId(), node.getType());
		boolean validExpr = ExprTypeChecker.check_expr(node.getExpr(), symb_map, errors);
		boolean validType = true;
		Type exprType = node.getExpr().typeof(symb_map);
		if (!node.getType().isCompatibleTo(exprType)){
			validType = false;
		}
		return (validId && validExpr && validType);
	}

	@Override
	public Boolean visit(Block node) {
		return visit(node.getStatements());
	}

	@Override
	public Boolean visit(IfStatement node) {
		boolean validExpr = isBooleanExpr(node.getExpr(), "if");
		boolean validStatement = node.getStatements().accept(this);
		return (validExpr && validStatement);
	}

	private boolean isBooleanExpr(Expr expr, String token) {
		boolean validExpr = ExprTypeChecker.check_expr(expr, symb_map, errors);
		if (validExpr){
			Type type = expr.typeof(symb_map);
			if(type.isCompatibleToBool()){
				return true;
			}
			errors.addError("Error: Expression type is not boolean at " + token);
		}
		return false;
	}

	@Override
	public Boolean visit(Form node) {
		return node.getStatements().accept(this);
	}

	@Override
	public Boolean visit(IfelseStatement node) {
		boolean validExpr = isBooleanExpr(node.getExpr(), "if");
		boolean validStatement_if = node.getStatements().accept(this);
		boolean validStatement_else = node.getElseStatements().accept(this);
		return (validExpr && validStatement_if && validStatement_else);
	}
	
}
