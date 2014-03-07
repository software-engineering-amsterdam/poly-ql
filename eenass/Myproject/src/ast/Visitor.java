package ast;

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
import ast.statement.StatementList;

public interface Visitor<T> {
	T visit(Pos node);
	T visit(Neg node);
	T visit(Not node);
	T visit(Add node);
	T visit(And node);
	T visit(Div node);
	T visit(Eq node);
	T visit(GEq node);
	T visit(GT node);
	T visit(LEq node);
	T visit(LT node);
	T visit(Mul node);
	T visit(NEq node);
	T visit(Or node);
	T visit(Sub node);
	T visit(BoolLiteral node);
	T visit(Identifier node);
	T visit(IntLiteral node);
	T visit(StrLiteral node);
	T visit(BoolType node);
	T visit(IntType node);
	T visit(StrType node);
	T visit(StatementList node);
	T visit(Question node);
	T visit(ComputedQuestion node);
	T visit(Block node);
	T visit(IfStatement node);
	T visit(IfelseStatement node);
	T visit(Form node);
	
}
