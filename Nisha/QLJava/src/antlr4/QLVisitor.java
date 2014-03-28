// Generated from QL.g4 by ANTLR 4.1

	package antlr4;
	import ast.form.*;
	import ast.type.*;
	import ast.literals.*;
	import expr.conditional.*;
	import expr.operation.*;
	import expr.relational.*;
	import expr.unary.*;
	import expr.Expr;
	import expr.Ident;
	
	

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull QLParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#ifelsestate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelsestate(@NotNull QLParser.IfelsestateContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(@NotNull QLParser.MulExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(@NotNull QLParser.RelExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull QLParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#valuetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuetype(@NotNull QLParser.ValuetypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull QLParser.PrimaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(@NotNull QLParser.StatementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(@NotNull QLParser.IfstatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(@NotNull QLParser.AddExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull QLParser.QuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#unExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnExpr(@NotNull QLParser.UnExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QLParser#forms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForms(@NotNull QLParser.FormsContext ctx);
}