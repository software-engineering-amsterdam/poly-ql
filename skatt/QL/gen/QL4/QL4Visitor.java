// Generated from grammar/QL4.g4 by ANTLR 4.2

	package QL4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QL4Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QL4Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QL4Parser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(@NotNull QL4Parser.MultExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#greExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreExpr(@NotNull QL4Parser.GreExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull QL4Parser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#geqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeqExpr(@NotNull QL4Parser.GeqExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#elseifcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifcondition(@NotNull QL4Parser.ElseifconditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#lesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLesExpr(@NotNull QL4Parser.LesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#plusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(@NotNull QL4Parser.PlusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#regQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegQuestion(@NotNull QL4Parser.RegQuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#compQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompQuestion(@NotNull QL4Parser.CompQuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(@NotNull QL4Parser.DecContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#minExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinExpr(@NotNull QL4Parser.MinExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull QL4Parser.IdentContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#workflowStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowStruct(@NotNull QL4Parser.WorkflowStructContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#neqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeqExpr(@NotNull QL4Parser.NeqExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(@NotNull QL4Parser.EqExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#elsecondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsecondition(@NotNull QL4Parser.ElseconditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#divExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(@NotNull QL4Parser.DivExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull QL4Parser.FormContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull QL4Parser.IntContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#ifcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfcondition(@NotNull QL4Parser.IfconditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#questionStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionStruct(@NotNull QL4Parser.QuestionStructContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#structures}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructures(@NotNull QL4Parser.StructuresContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull QL4Parser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#wrapExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrapExpr(@NotNull QL4Parser.WrapExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#leqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeqExpr(@NotNull QL4Parser.LeqExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#negExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(@NotNull QL4Parser.NegExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link QL4Parser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull QL4Parser.BoolContext ctx);
}