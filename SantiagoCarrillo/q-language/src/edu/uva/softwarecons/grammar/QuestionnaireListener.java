// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionnaireParser}.
 */
public interface QuestionnaireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(@NotNull QuestionnaireParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(@NotNull QuestionnaireParser.ElseContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#simpleQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#simpleQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#computedQuestion}.
	 * @param ctx the parse tree
	 */
	void enterComputedQuestion(@NotNull QuestionnaireParser.ComputedQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#computedQuestion}.
	 * @param ctx the parse tree
	 */
	void exitComputedQuestion(@NotNull QuestionnaireParser.ComputedQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(@NotNull QuestionnaireParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(@NotNull QuestionnaireParser.IntegerContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull QuestionnaireParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull QuestionnaireParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull QuestionnaireParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull QuestionnaireParser.IntContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(@NotNull QuestionnaireParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(@NotNull QuestionnaireParser.CompareContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(@NotNull QuestionnaireParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(@NotNull QuestionnaireParser.DateContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(@NotNull QuestionnaireParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(@NotNull QuestionnaireParser.DecimalContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull QuestionnaireParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull QuestionnaireParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull QuestionnaireParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull QuestionnaireParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull QuestionnaireParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull QuestionnaireParser.NotContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(@NotNull QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(@NotNull QuestionnaireParser.QuestionnaireContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(@NotNull QuestionnaireParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(@NotNull QuestionnaireParser.IfContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull QuestionnaireParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull QuestionnaireParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#addSub}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(@NotNull QuestionnaireParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#addSub}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(@NotNull QuestionnaireParser.AddSubContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#money}.
	 * @param ctx the parse tree
	 */
	void enterMoney(@NotNull QuestionnaireParser.MoneyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#money}.
	 * @param ctx the parse tree
	 */
	void exitMoney(@NotNull QuestionnaireParser.MoneyContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull QuestionnaireParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull QuestionnaireParser.BooleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#parenthesis}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(@NotNull QuestionnaireParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#parenthesis}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(@NotNull QuestionnaireParser.ParenthesisContext ctx);
}