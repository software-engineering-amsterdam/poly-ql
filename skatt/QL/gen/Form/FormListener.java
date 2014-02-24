// Generated from grammar/Form.g4 by ANTLR 4.2

	package Form;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormParser}.
 */
public interface FormListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull FormParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull FormParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FormParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull FormParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull FormParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link FormParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull FormParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull FormParser.ConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FormParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(@NotNull FormParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(@NotNull FormParser.LabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link FormParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull FormParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull FormParser.QuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FormParser#construct}.
	 * @param ctx the parse tree
	 */
	void enterConstruct(@NotNull FormParser.ConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormParser#construct}.
	 * @param ctx the parse tree
	 */
	void exitConstruct(@NotNull FormParser.ConstructContext ctx);
}