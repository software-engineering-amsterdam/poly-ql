package typecheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ast.Visitor;
import ast.errormsg.Error;
import ast.errormsg.Message;
import ast.form.Block;
import ast.form.Computedquest;
import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Question;
import ast.form.Statement;
import ast.form.StatementList;
import ast.literals.BoolLiteral;
import ast.literals.IntLiteral;
import ast.literals.StrLiteral;
import ast.type.Booltype;
import ast.type.Inttype;
import ast.type.Strtype;
import ast.type.Type;
import expr.Expr;
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

public class Typecheck implements Visitor<Boolean>{
	
	private final Map<Ident,Type> identifier;
	private List<Message> errors = new ArrayList<Message>();
	
	public Typecheck (Map<Ident,Type> identifier)
	{
		this.identifier= identifier;
	}
	
	public List<Message> getErrors(){
		return this.errors;
	}
	
	public boolean ValidExpression(Expr exp)
	{   
		boolean result= exp.typeof(identifier).accept(this);
		return result;
	}
	
	public boolean ValidInteger(Expr operand, String side, String token)
	{
		if(ValidExpression(operand))
		{
			Type optype = operand.typeof(identifier);
			if(optype.isInt())
			{
				return true;
			}
			else {
				   errors.add(new Error("Invalid Type at " + side + " " + token));
			}
		}
		return false;
	}
	
	public boolean ValidInteger(Expr lhs, Expr rhs, String operator)
	{
		boolean Validop1 = ValidInteger(lhs, "left side", operator);
		boolean Validop2 = ValidInteger(rhs, "right side", operator);
		return (Validop1 && Validop2);
	}
	
	public boolean ValidBoolean(Expr operand, String side, String token)
	{ 
		if(ValidExpression(operand))
		{ 
			Type optype = operand.typeof(identifier);
			if(optype.isBool())
			{
				return true;
			}
			else{
				errors.add(new Error("Invalid/Incompatible Type at " + side + "  " + token));
			}
		}
		return false;
	}
	
	public boolean ValidBoolean(Expr lhs, Expr rhs, String operator)
	{ 
		boolean Validop1 = ValidBoolean(lhs, "left side", operator);
		boolean Validop2 = ValidBoolean(rhs, "right side", operator);
		return (Validop1 && Validop2);
	}
	
	public boolean Equaltypes(Expr lhs, Expr rhs, String token){
		boolean ValidLhs = ValidExpression(lhs);
		boolean ValidRhs = ValidExpression(rhs);

		if(ValidLhs && ValidRhs ){
			Type type1 = lhs.typeof(identifier);
			Type type2 = rhs.typeof(identifier);

			if(((type1.isStr() && type2.isStr()) || (type1.isBool() && type2.isBool()) || (type1.isInt() && type2.isInt()))){
				return true;
			}
			else{
				errors.add(new Error("Not Equal types at "));
			}
		}
		return false;
	}
	
	@Override
	public Boolean visit(And node) {
		return ValidBoolean(node.getLhs(), node.getRhs(), "&&") ;
	}

	@Override
	public Boolean visit(Or node) {
		return ValidBoolean(node.getLhs(), node.getRhs(), "||");
	}

	@Override
	public Boolean visit(Ident node) {
		if(identifier.containsKey(node))
		{
			return true;
		}
		
		else{
			errors.add(new Error("Undefined identifier at " + node.getId()));
		}
		return false;
	}

	@Override
	public Boolean visit(Form node) {
		return node.getStatements().accept(this);
	}

	@Override
	public Boolean visit(Question node) {
		return checkIdent(node.getId(), node.getType());
	}
	
	public boolean checkIdent(Ident id, Type type)
	{
	   if(identifier.containsKey(id) && identifier.get(id).istype(type))
		{
			return false;
		}
		else
		{
		identifier.put(id, type);
		return true;
		}
		
	}

	
	@Override
	public Boolean visit(IfElse node) {
		boolean validExpr = ValidExpression(node.getExpr());
		boolean validIfState = node.getStatements().accept(this);
		boolean validElseState = node.getStatement1().accept(this);
		return (validExpr && validIfState && validElseState );
	}

	@Override
	public Boolean visit(Ifstate node) {
		boolean validExpr = ValidBoolean(node.getExpr(), "", "if");
		boolean validState = node.getStatements().accept(this);
		return (validExpr && validState);
		
		
	}

	@Override
	public Boolean visit(Add node) {
		return ValidInteger(node.getLhs(),node.getRhs(), "+");
	}

	@Override
	public Boolean visit(Div node) {
		return ValidInteger(node.getLhs(),node.getRhs(), "/");
	}

	@Override
	public Boolean visit(Mul node) {
		return ValidInteger(node.getLhs(),node.getRhs(), "*");
	}

	@Override
	public Boolean visit(Sub node) {
		return ValidInteger(node.getLhs(),node.getRhs(), "-");
	}

	@Override
	public Boolean visit(Eq node) {
		return Equaltypes(node.getLhs(),node.getRhs(), "==");
	}

	@Override
	public Boolean visit(GEq node) {
		return Equaltypes(node.getLhs(),node.getRhs(), ">=");
	}

	@Override
	public Boolean visit(GT node) {
		return Equaltypes(node.getLhs(),node.getRhs(), ">");
	}

	@Override
	public Boolean visit(LEq node) {
		return Equaltypes(node.getLhs(),node.getRhs(), "<=");
	}

	@Override
	public Boolean visit(LT node) {
		return Equaltypes(node.getLhs(),node.getRhs(),"<");
	}

	@Override
	public Boolean visit(NEq node) {
		return Equaltypes(node.getLhs(),node.getRhs(),"!=");
	}

	@Override
	public Boolean visit(Booltype node) {
		return true;
	}

	@Override
	public Boolean visit(Inttype node) {
		return true;
	}

	@Override
	public Boolean visit(Strtype node) {
		return true;
	}

	@Override
	public Boolean visit(Neg node) {
		return ValidInteger(node.getOperand(), "", "-");
	}

	@Override
	public Boolean visit(Not node) {
		return ValidInteger(node.getOperand(), "", "!");
	}

	@Override
	public Boolean visit(Pos node) {
		return ValidInteger(node.getOperand(), "", "+");
	}

	@Override
	public Boolean visit(StatementList statementList) {
		for(Statement statement: statementList.getList())
		{
			if(!statement.accept(this))
		 {
			 return false;
		 }
	 }
	 return true;
	}
	
	@Override
	public Boolean visit(Computedquest node) {
		boolean ValidId = checkIdent(node.getId(), node.getType());
		boolean ValidExpr = ValidExpression(node.getExpr());
		boolean ValidType = Validtype(node.getId(),node.getType());
        return (ValidId && ValidExpr && ValidType);
	}
	
	public boolean Validtype(Ident id, Type type)
	{
		if(identifier.get(id).istype(type))
		{
			return true;
		}
		return false;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
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
	public Boolean visit(Block block) {
		return visit (block.getStatements());
	}


	


	

	
	

	

}
