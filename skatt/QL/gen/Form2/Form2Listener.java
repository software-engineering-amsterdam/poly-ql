// Generated from grammar/Form2.g4 by ANTLR 4.2

	package Form2;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Form2Parser}.
 */
public interface Form2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Form2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull Form2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull Form2Parser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(@NotNull Form2Parser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(@NotNull Form2Parser.StructureContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull Form2Parser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull Form2Parser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#elseifcondition}.
	 * @param ctx the parse tree
	 */
	void enterElseifcondition(@NotNull Form2Parser.ElseifconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#elseifcondition}.
	 * @param ctx the parse tree
	 */
	void exitElseifcondition(@NotNull Form2Parser.ElseifconditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(@NotNull Form2Parser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(@NotNull Form2Parser.LabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull Form2Parser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull Form2Parser.QuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void enterIfcondition(@NotNull Form2Parser.IfconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void exitIfcondition(@NotNull Form2Parser.IfconditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void enterElsecondition(@NotNull Form2Parser.ElseconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void exitElsecondition(@NotNull Form2Parser.ElseconditionContext ctx);
}