// Generated from QLang.g4 by ANTLR 4.1
package antlr;

import ast.expr.Expr;
import ast.expr.IdentLiteral;
import ast.expr.binExpr.*;
import ast.expr.unExpression.*;
import ast.expr.literal.*;
import ast.expr.types.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLangParser}.
 */
public interface QLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLangParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull QLangParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull QLangParser.AndExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull QLangParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull QLangParser.PrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLangParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(@NotNull QLangParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(@NotNull QLangParser.AddExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLangParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(@NotNull QLangParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(@NotNull QLangParser.MulExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull QLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull QLangParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLangParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(@NotNull QLangParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(@NotNull QLangParser.RelExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLangParser#unExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnExpr(@NotNull QLangParser.UnExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#unExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnExpr(@NotNull QLangParser.UnExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLangParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull QLangParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLangParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull QLangParser.OrExprContext ctx);
}