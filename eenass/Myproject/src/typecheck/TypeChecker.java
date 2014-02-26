package typecheck;

import ast.ASTNode;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.IdentLiteral;
import ast.expr.binExpr.*;
import ast.expr.literal.*;
import ast.expr.types.*;
import ast.expr.unExpression.*;

public class TypeChecker implements Visitor<Boolean>{
	
	private final Symboles symb_map;

	public TypeChecker(Symboles symb_map) {
		this.symb_map = symb_map;
	}
	
	public boolean check_symb(ASTNode node, Symboles symboles){
		TypeChecker visitor = new TypeChecker(symboles);
		return node.accept(visitor);		
	}
	
	public boolean isValidExpr(Expr exp){
		return exp.accept(this);		
	}
	
	public boolean isValidInt(Expr exp){
		if (isValidExpr(exp)){
			Types type = exp.typeof(symb_map);
			if((type != null) && (type.isCompatableToInt())){
				return true;
			}
		}
		return false;
	}
	
	public boolean isValidInt(Expr lhs, Expr rhs){
		boolean isValid_lhs = isValidInt(lhs);
		boolean isValid_rhs = isValidInt(rhs);
		
		return (isValid_lhs && isValid_rhs);
	}
	
	public boolean isValidBool(Expr exp){
		if (isValidExpr(exp)){
			Types type = exp.typeof(symb_map);
			if((type != null) && (type.isCompatableToBool())){
				return true;
			}
		}
		return false;
	}
	
	public boolean isValidBool(Expr lhs, Expr rhs){
		boolean isValid_lhs = isValidBool(lhs);
		boolean isValid_rhs = isValidBool(rhs);
		
		return (isValid_lhs && isValid_rhs);
	}	

	
	public boolean Equel_types(Expr lhs, Expr rhs){
		boolean isValid_lhs = isValidExpr(lhs);
		boolean isValid_rhs = isValidExpr(rhs);
		
		if(isValid_lhs && isValid_rhs){
			Types t1 = lhs.typeof(symb_map);
			Types t2 = rhs.typeof(symb_map);
			
			if((t1 != null && t2 != null) && (t1.isCompatableTo(t2))){
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public Boolean visit(Pos node) {
		return isValidInt(node.getOperand());
	}

	@Override
	public Boolean visit(Neg node) {
		return isValidInt(node.getOperand());
	}

	@Override
	public Boolean visit(Not node) {
		return isValidBool(node.getOperand());
	}

	@Override
	public Boolean visit(Add node) {
		return isValidInt(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(And node) {
		return isValidBool(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(Div node) {
		return isValidInt(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(Eq node) {
		return isValidBool(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(GEq node) {
		return isValidBool(node.get_lhs(), node.get_rhs());
	}
	
	@Override
	public Boolean visit(GT node) {
		return true;
	}

	@Override
	public Boolean visit(LEq node) {
		return isValidBool(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(LT node) {
		return isValidBool(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(Mul node) {
		return isValidInt(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(NEq node) {
		return isValidBool(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(Or node) {
		return isValidBool(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(Sub node) {
		return isValidInt(node.get_lhs(), node.get_rhs());
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(IdentLiteral node) {
		if(symb_map.containsSymb(node.getIdentName())){
			return true;
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

}
