package typecheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import antlr4.QLParser;
import ast.ASTNode;
import ast.Visitor;
import ast.errormsg.Error;
import ast.evaluate.Bool;
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
	private Error errors;
	private List<String> labels  ;
	
	public String get_errorList(){
		return errors.toString();
	}
	
	public void checkquestion(String label){
		//System.out.println(label);
		 if(labels.contains(label)){
			 errors.addWarning("Warning: Duplicate label at " + label); 
	 }
	 labels.add(label);
	}
	
	public boolean checkId(ASTNode node, Map<Ident,Type> identifier, Error errors){
		Typecheck tc = new Typecheck(identifier, errors);
		return node.accept(tc);		
	}
	
	public Typecheck (Map<Ident,Type> identifier, Error errors)
	{
		this.identifier= identifier;
		this.errors = errors;
		labels = new ArrayList<String>();
	}
	
	
	public boolean ValidExpression(Expr exp)
	{   
		
		if(exp.getClass()==Ident.class){
			return true;
		}
		return exp.accept(this);
	}
	
	public boolean ValidInteger(Expr operand, String side, String operator)
	{	
		if (ValidExpression(operand)){
			Type type = operand.typeof(identifier);
			if(type.isInt()){
				return true;
			}
			errors.addError("Error: Invalid/Incompatible Type at " + side + " " + operator);
		}
		return false;
	}
	
	public boolean ValidInteger(Expr lhs, Expr rhs, String operator)
	{
		boolean Validop1 = ValidInteger(lhs, "left side", operator);
		boolean Validop2 = ValidInteger(rhs, "right side", operator);
		return (Validop1 && Validop2);
	}
	

	public boolean ValidString(Expr operand, String side, String operator)
	{
		if(ValidExpression(operand))
		{
			Type optype = operand.typeof(identifier);
			if((optype!=null) && (optype.isStr()))
			{
				return true;
			}
			else {
				errors.addError("Error: Invalid Type at " + side + " " + operator);
			}
		}
		return false;
	}
	
	public boolean ValidString(Expr lhs, Expr rhs, String operator)
	{
		boolean Validop1 = ValidString(lhs, "left side", operator);
		boolean Validop2 = ValidString(rhs, "right side", operator);
		return (Validop1 && Validop2);
	}
	public boolean ValidBoolean(Expr operand, String side, String operator)
	{ 
		if(ValidExpression(operand))
		{ 
			Type optype = operand.typeof(identifier);
			if((optype!=null) && (optype.isBool()))
			{
				return true;
			}
			else{
				errors.addError("Error: Invalid Type at " + side + " " + operator);			}
		}
		return false;
	}
	
	public boolean ValidBoolean(Expr lhs, Expr rhs, String operator)
	{ 
		boolean Validop1 = ValidBoolean(lhs, "left side", operator);
		boolean Validop2 = ValidBoolean(rhs, "right side", operator);
		return (Validop1 && Validop2);
	}
	
	public boolean Equaltypes(Expr lhs, Expr rhs, String operator){
		
		boolean ValidLhs = ValidExpression(lhs);
		boolean ValidRhs = ValidExpression(rhs);

		if(ValidLhs && ValidRhs){
			Type t1 = lhs.typeof(identifier);
			Type t2 = rhs.typeof(identifier);
			if(t1.istype(t2)){
				return true;
			}
			errors.addError("Error: Incompataible types at " + operator);
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
		
		
			errors.addError("Error: Undefined identifier: " + node.getId());
		return false;
	}

	@Override
	public Boolean visit(Form node) {
		return node.getStatements().accept(this);
	}

	@Override
	public Boolean visit(Question node) {
		checkquestion(node.getDescription());
		return checkIdent(node.getId(), node.getType());
	}
	
	public boolean checkIdent(Ident id, Type type)
	{
		HashMap<String, Ident> IdentKey = new HashMap<String, Ident>();
		for(Ident key: identifier.keySet())
		{
			IdentKey.put(key.id, key);
		}
		
		if(IdentKey.containsKey(id.id) && (identifier.get(IdentKey.get(id.id)).istype(type)))
		{
			errors.addError("Used Identifier " + id.getId());
			return false;
		}
		else if(IdentKey.containsKey(id.id) && !(identifier.get(IdentKey.get(id.id)).istype(type)))
		{
			errors.addError("Used Identifier with Invalid type " + id.getId());
			return false;
		}
		else
		{
		identifier.put(id, type);
		return true;
		}
//		for (Ident key: identifier.keySet()){
//			
//				if(id.id.equals(key.id) && identifier.get(key).istype(type))
//				{
//				   errors.addError("Error: Used Identifier " + id.getId());
//					return false;
//				}
//				
//				else if(id.id.equals(key.id) &&!(identifier.get(key).istype(type)))
//				{
//					errors.addError("Error: Used Identifier with Invalid type " + id.getId());
//					return false;
//				}
//				
//				
//		}
//		identifier.put(id, type);
//		return true;
//		
	}

	
	@Override
	public Boolean visit(IfElse node) {
		labels.clear();
		boolean validExpr = ValidBoolean(node.getExpr(), "", "else");
		boolean validIfState = node.getStatements().accept(this);
		boolean validElseState = node.getStatement1().accept(this);
		return (validExpr && validIfState && validElseState );
	}

	@Override
	public Boolean visit(Ifstate node) {
		labels.clear();
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
		return ValidBoolean(node.getOperand(), "", "!");
	}

	@Override
	public Boolean visit(Pos node) {
		return ValidInteger(node.getOperand(), "", "+");
	}

	@Override
	public Boolean visit(StatementList statementList) {
		boolean result = true;
		for(Statement statement: statementList.getList())
		{	
			if(!statement.accept(this)){
				result = false;
			}
	 }
	 return result;
	}
	
	@Override
	public Boolean visit(Computedquest node) {
		boolean ValidId = checkIdent(node.getId(), node.getType());
		boolean ValidExpr = ValidExpression(node.getExpr());
		boolean ValidType = Validtype(node.getId(),node.getType());
		//boolean ValidType = true;
		Type exprType = node.getExpr().typeof(identifier);
		if (!node.getType().istype(exprType)){
			ValidType = false;
			errors.addError("Not a Valid type: "+ exprType);
		}
        return (ValidId && ValidExpr && ValidType);
	}
	
	public boolean Validtype(Ident id, Type type)
	{
		for (Ident key : identifier.keySet()) {
			if (id.id.equals(key.id)) {
				if (identifier.get(key).istype(type)) {
					return true;
				}
			}
		}
		errors.addError("Error: Invalid Type ");
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
