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
	 * Enter a parse tree produced by {@link QLParser#ifelsestate}.
	 * @param ctx the parse tree
	 */
	void enterIfelsestate(@NotNull QLParser.IfelsestateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifelsestate}.
	 * @param ctx the parse tree
	 */
	void exitIfelsestate(@NotNull QLParser.IfelsestateContext ctx);

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
	 * Enter a parse tree produced by {@link QLParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull QLParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull QLParser.OrExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull QLParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#valuetype}.
	 * @param ctx the parse tree
	 */
	void enterValuetype(@NotNull QLParser.ValuetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#valuetype}.
	 * @param ctx the parse tree
	 */
	void exitValuetype(@NotNull QLParser.ValuetypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull QLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull QLParser.PrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(@NotNull QLParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(@NotNull QLParser.StatementsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(@NotNull QLParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(@NotNull QLParser.IfstatementContext ctx);

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
	 * Enter a parse tree produced by {@link QLParser#forms}.
	 * @param ctx the parse tree
	 */
	void enterForms(@NotNull QLParser.FormsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#forms}.
	 * @param ctx the parse tree
	 */
	void exitForms(@NotNull QLParser.FormsContext ctx);
}