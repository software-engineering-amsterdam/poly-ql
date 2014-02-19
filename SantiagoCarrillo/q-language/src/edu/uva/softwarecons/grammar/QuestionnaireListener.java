package edu.uva.softwarecons.grammar;// Generated from Questionnaire.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionnaireParser}.
 */
public interface QuestionnaireListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull QuestionnaireParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull QuestionnaireParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QuestionnaireParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QuestionnaireParser.QuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull QuestionnaireParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull QuestionnaireParser.TypeContext ctx);
}