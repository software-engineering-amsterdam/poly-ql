// Generated from QL.g4 by ANTLR 4.2

package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.form.stat.*;
import ql.ast.form.*;
import ql.ast.type.*;
import ql.ast.expr.exprType.*;
import ql.ast.expr.operation.*;
import ql.ast.expr.operation.add.*;
import ql.ast.expr.operation.andor.*;
import ql.ast.expr.operation.mul.*;
import ql.ast.expr.operation.rel.*;
import ql.ast.expr.operation.un.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull QLParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull QLParser.AndExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QLParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#formItems}.
	 * @param ctx the parse tree
	 */
	void enterFormItems(@NotNull QLParser.FormItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#formItems}.
	 * @param ctx the parse tree
	 */
	void exitFormItems(@NotNull QLParser.FormItemsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(@NotNull QLParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(@NotNull QLParser.AddExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(@NotNull QLParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(@NotNull QLParser.MulExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull QLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull QLParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QLParser.QuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(@NotNull QLParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(@NotNull QLParser.RelExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull QLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull QLParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#unExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnExpr(@NotNull QLParser.UnExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#unExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnExpr(@NotNull QLParser.UnExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull QLParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull QLParser.StatContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull QLParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull QLParser.OrExprContext ctx);
}