// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionnaireParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionnaireVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(@NotNull QuestionnaireParser.ElseContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#simpleQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#computedQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedQuestion(@NotNull QuestionnaireParser.ComputedQuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(@NotNull QuestionnaireParser.IntegerContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull QuestionnaireParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull QuestionnaireParser.IntContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(@NotNull QuestionnaireParser.CompareContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#mulDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(@NotNull QuestionnaireParser.DateContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(@NotNull QuestionnaireParser.DecimalContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull QuestionnaireParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull QuestionnaireParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull QuestionnaireParser.NotContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(@NotNull QuestionnaireParser.QuestionnaireContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(@NotNull QuestionnaireParser.IfContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull QuestionnaireParser.StringContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#addSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(@NotNull QuestionnaireParser.AddSubContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#money}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoney(@NotNull QuestionnaireParser.MoneyContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(@NotNull QuestionnaireParser.BooleanContext ctx);

	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#parenthesis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(@NotNull QuestionnaireParser.ParenthesisContext ctx);
}