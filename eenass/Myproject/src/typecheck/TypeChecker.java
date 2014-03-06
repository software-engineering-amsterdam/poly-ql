package typecheck;

import ast.ASTNode;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.binExpr.*;
import ast.expr.literal.*;
import ast.expr.types.*;
import ast.expr.unExpression.*;
import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.Statement;
import ast.statement.StatementList;

public class TypeChecker implements Visitor<Boolean>{
	
	private final Symboles symb_map;
	private ErrorList errors;

	public TypeChecker(Symboles symb_map, ErrorList errors) {
		this.symb_map = symb_map;
		this.errors = errors;
	}
	public String get_errorList(){
		return errors.toString();
	}
	
	public boolean check_symb(ASTNode node, Symboles symboles, ErrorList errors){
		TypeChecker visitor = new TypeChecker(symboles, errors);
		return node.accept(visitor);		
	}
	
	public boolean isValidExpr(Expr exp){
		return exp.accept(this);		
	}
	
	public boolean isValidInt(Expr exp, String side, String token){
		if (isValidExpr(exp)){
			Type type = exp.typeof(symb_map);
			if((type != null) && (type.isCompatibleToInt())){
				return true;
			}
			else{
				errors.addError("Invalid Type at " + side + " " + token);
			}
		}
		return false;
	}
	
	public boolean isValidInt(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidInt(lhs, "left side", token);
		boolean isValid_rhs = isValidInt(rhs, "right side", token);		
		return (isValid_lhs && isValid_rhs);
	}
	
	public boolean isValidBool(Expr exp, String side, String token){
		if (isValidExpr(exp)){
			Type type = exp.typeof(symb_map);
			if((type != null) && (type.isCompatibleToBool())){
				return true;
			}
			else{
				errors.addError("Invalid Type at " + side + "  " + token);
			}
		}
		return false;
	}
	
	public boolean isValidBool(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidBool(lhs, "left side", token);
		boolean isValid_rhs = isValidBool(rhs, "right side", token);
		return (isValid_lhs && isValid_rhs);
	}	
	
	public boolean areEquel_types(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidExpr(lhs);
		boolean isValid_rhs = isValidExpr(rhs);
				
		if(isValid_lhs && isValid_rhs){
			Type t1 = lhs.typeof(symb_map);
			Type t2 = rhs.typeof(symb_map);
			
			if((t1 != null && t2 != null) && (t1.isCompatibleTo(t2))){
				return true;
			}
			else{
				errors.addError("Incompataible types at " + token);
			}
		}
		return false;
	}
	
	public boolean areRelationalTypes(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidExpr(lhs);
		boolean isValid_rhs = isValidExpr(rhs);
		if(isValid_lhs && isValid_rhs){
			Type t1 = lhs.typeof(symb_map);
			Type t2 = rhs.typeof(symb_map);
			
			if((t1 != null && t2 != null) && ((t1.isCompatibleToStr() && t2.isCompatibleToStr()) ||
					(t1.isCompatibleToInt() && t2.isCompatibleToInt()))){
				return true;
				
			}	
			else{
				errors.addError("Incompataible types at " + token);
			}
		}
		return false;
	}
	
	
	@Override
	public Boolean visit(Pos node) {
		return isValidInt(node.getOperand(), "", "+");
	}

	@Override
	public Boolean visit(Neg node) {
		return isValidInt(node.getOperand(), "", "-");
	}

	@Override
	public Boolean visit(Not node) {
		return isValidBool(node.getOperand(), "", "!");
	}

	@Override
	public Boolean visit(Add node) {
		return isValidInt(node.get_lhs(), node.get_rhs(), "+");
	}

	@Override
	public Boolean visit(And node) {
		return isValidBool(node.get_lhs(), node.get_rhs(), "&&");
	}

	@Override
	public Boolean visit(Div node) {
		return isValidInt(node.get_lhs(), node.get_rhs(), "/");
	}

	@Override
	public Boolean visit(Eq node) {
		return areEquel_types(node.get_lhs(), node.get_rhs(), "==");
	}

	@Override
	public Boolean visit(GEq node) {
		return areRelationalTypes(node.get_lhs(), node.get_rhs(), ">=");
	}
	
	@Override
	public Boolean visit(GT node) {
		return areRelationalTypes(node.get_lhs(), node.get_rhs(), ">");
	}

	@Override
	public Boolean visit(LEq node) {
		return areRelationalTypes(node.get_lhs(), node.get_rhs(), "<=");
	}

	@Override
	public Boolean visit(LT node) {
		return areRelationalTypes(node.get_lhs(), node.get_rhs(), "<");
	}

	@Override
	public Boolean visit(Mul node) {
		return isValidInt(node.get_lhs(), node.get_rhs(), "*");
	}

	@Override
	public Boolean visit(NEq node) {
		return areEquel_types(node.get_lhs(), node.get_rhs(), "!=");
	}

	@Override
	public Boolean visit(Or node) {
		return isValidBool(node.get_lhs(), node.get_rhs(), "||");
	}

	@Override
	public Boolean visit(Sub node) {
		return isValidInt(node.get_lhs(), node.get_rhs(), "-");
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(Identifier node) {
		if(symb_map.containsSymb(node.getIdentName())){
			return true;
		}
		else{
			errors.addError("Invalid identifier at " + node.getIdentName());
		}
		return false;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(StrLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(BoolType node) {
		return true;
	}

	@Override
	public Boolean visit(IntType node) {
		return true;
	}

	@Override
	public Boolean visit(StrType nodde) {
		return true;
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
		return putIdentifier(node.getId(), node.getType());
	}
	
	private boolean putIdentifier(Identifier id, Type type){
		if(symb_map.containsSymb(id.getIdentName())){
			errors.addError("Invalid identifier (already used) " + id.getIdentName());
			return false;
		}
		symb_map.put(id.getIdentName(), type);
		return true;		
	}

	@Override
	public Boolean visit(ComputedQuestion node) {
		boolean validId = putIdentifier(node.getId(), node.getType());
		boolean validExpr = isValidExpr(node.getExpr());
		boolean validType = true;
		Type exprType = node.getExpr().typeof(symb_map);
		if ((exprType != null) && (!node.getType().isCompatibleTo(exprType))){
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
		boolean validExpr = isValidBool(node.getExpr(), "", "if");
		boolean validStatement = node.getStatements().accept(this);
		return (validExpr && validStatement);
	}

	@Override
	public Boolean visit(Form node) {
		return node.getStatements().accept(this);
	}

	@Override
	public Boolean visit(IfelseStatement node) {
		boolean validExpr = isValidExpr(node.getExpr());
		boolean validStatement_if = node.getStatements().accept(this);
		boolean validStatement_else = node.getElseStatements().accept(this);
		return (validExpr && validStatement_if && validStatement_else);
	}

}
