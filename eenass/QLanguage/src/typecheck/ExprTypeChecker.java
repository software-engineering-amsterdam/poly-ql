package typecheck;

import ast.expr.Expr;
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
import ast.expr.unExpr.Neg;
import ast.expr.unExpr.Not;
import ast.expr.unExpr.Pos;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public class ExprTypeChecker implements ExprVisitor<Boolean>{

	private final SymbolTable symbolTable;
	private ErrorList errors;

	private ExprTypeChecker(SymbolTable symb_map, ErrorList errors) {
		this.symbolTable = symb_map;
		this.errors = errors;
	}

	public static boolean check_expr(Expr expr, SymbolTable table, ErrorList errors){
		ExprTypeChecker checker = new ExprTypeChecker(table, errors);
		return expr.accept(checker);
	}
	
	private boolean isValidExpr(Expr exp){
		return exp.accept(this);		
	}
	
	private boolean isValidInt(Expr exp, String side, String token){
		if (isValidExpr(exp)){
			Type type = exp.typeof(symbolTable);
			if(type.isCompatibleToInt()){
				return true;
			}
			errors.addError("Error: Invalid/Incompatible Type at " + side + " " + token);
		}
		return false;
	}
	
	private boolean isValidInt(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidInt(lhs, "left side", token);
		boolean isValid_rhs = isValidInt(rhs, "right side", token);		
		return (isValid_lhs && isValid_rhs);
	}
	
	private boolean isValidBool(Expr exp, String side, String token){
		if (isValidExpr(exp)){
			Type type = exp.typeof(symbolTable);
			if(type.isCompatibleToBool()){
				return true;
			}
			errors.addError("Error: Invalid/Incompatible Type at " + side + "  " + token);
		}
		return false;
	}
	
	private boolean isValidBool(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidBool(lhs, "left side", token);
		boolean isValid_rhs = isValidBool(rhs, "right side", token);
		return (isValid_lhs && isValid_rhs);
	}	
	
	private boolean areEqual_types(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidExpr(lhs);
		boolean isValid_rhs = isValidExpr(rhs);
				
		if(isValid_lhs && isValid_rhs){
			Type t1 = lhs.typeof(symbolTable);
			Type t2 = rhs.typeof(symbolTable);
			
			if(t1.isCompatibleTo(t2)){
				return true;
			}
			errors.addError("Error: Incompataible types at " + token);
		}
		return false;
	}
	
	private boolean areRelationalTypes(Expr lhs, Expr rhs, String token){
		boolean isValid_lhs = isValidExpr(lhs);
		boolean isValid_rhs = isValidExpr(rhs);
		if(isValid_lhs && isValid_rhs){
			Type t1 = lhs.typeof(symbolTable);
			Type t2 = rhs.typeof(symbolTable);			
			if((t1.isCompatibleToStr() && t2.isCompatibleToStr()) ||
					(t1.isCompatibleToInt() && t2.isCompatibleToInt())){
				return true;				
			}	
			errors.addError("Error: Incompataible types at " + token);
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
		return isValidInt(node.getLhs(), node.getRhs(), "+");
	}

	@Override
	public Boolean visit(And node) {
		return isValidBool(node.getLhs(), node.getRhs(), "&&");
	}

	@Override
	public Boolean visit(Div node) {
		return isValidInt(node.getLhs(), node.getRhs(), "/");
	}

	@Override
	public Boolean visit(Eq node) {
		return areEqual_types(node.getLhs(), node.getRhs(), "==");
	}

	@Override
	public Boolean visit(GEq node) {
		return areRelationalTypes(node.getLhs(), node.getRhs(), ">=");
	}
	
	@Override
	public Boolean visit(GT node) {
		return areRelationalTypes(node.getLhs(), node.getRhs(), ">");
	}

	@Override
	public Boolean visit(LEq node) {
		return areRelationalTypes(node.getLhs(), node.getRhs(), "<=");
	}

	@Override
	public Boolean visit(LT node) {
		return areRelationalTypes(node.getLhs(), node.getRhs(), "<");
	}

	@Override
	public Boolean visit(Mul node) {
		return isValidInt(node.getLhs(), node.getRhs(), "*");
	}

	@Override
	public Boolean visit(NEq node) {
		return areEqual_types(node.getLhs(), node.getRhs(), "!=");
	}

	@Override
	public Boolean visit(Or node) {
		return isValidBool(node.getLhs(), node.getRhs(), "||");
	}

	@Override
	public Boolean visit(Sub node) {
		return isValidInt(node.getLhs(), node.getRhs(), "-");
	}

	@Override
	public Boolean visit(Identifier node) {
		if(symbolTable.containsSymbol(node)){
			return true;
		}		
		errors.addError("Error: Undefined identifier: " + node.getIdentName());
		return false;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}
	
	@Override
	public Boolean visit(StrLiteral node) {
		return true;
	}
}