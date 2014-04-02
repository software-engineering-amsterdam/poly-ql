package ast.visitors;

import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.StatementList;

public interface StatementVisitor<T> {
	T visit(Question node);
	T visit(ComputedQuestion node);
	T visit(Block node);
	T visit(IfStatement node);
	T visit(IfelseStatement node);
	T visit(Form node);
	T visit(StatementList node);
}
