package ast;

import javax.swing.JComponent;

import ast.literals.BoolLiteral;
import ast.literals.IntLiteral;
import ast.literals.StrLiteral;
import ast.form.Block;
import ast.form.Computedquest;
import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Question;
import ast.form.StatementList;
import ast.type.Booltype;
import ast.type.Inttype;
import ast.type.Strtype;
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

public interface Visitor<T>{
	
	public T visit (And node);
	public T visit (Or node);
	public T visit (Ident node);
	public T visit (Form node);
	public T visit (Question node);
	public T visit (IfElse node);
	public T visit (Ifstate node);
	public T visit (Add node);
	public T visit (Div node);
	public T visit (Mul node);
	public T visit (Sub node);
	public T visit (Eq node);
	public T visit (GEq node);
	public T visit (GT node);
	public T visit (LEq node);
	public T visit (LT node);
	public T visit (NEq node);
	public T visit (Booltype node);
	public T visit (Inttype node);
	public T visit (Strtype node);
	public T visit (Neg node);
	public T visit (Not node);
	public T visit (Pos node);
	public T visit (StatementList statementList);
	public T visit (Computedquest node);
	public T visit (BoolLiteral node);
	public T visit (IntLiteral node);
	public T visit (StrLiteral node);
	public T visit(Block block);
	

}