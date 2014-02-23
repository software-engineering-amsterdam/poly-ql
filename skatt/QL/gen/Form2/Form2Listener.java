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
	 * Enter a parse tree produced by {@link Form2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(@NotNull Form2Parser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(@NotNull Form2Parser.MultExprContext ctx);

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
	 * Enter a parse tree produced by {@link Form2Parser#identExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdentExpr(@NotNull Form2Parser.IdentExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#identExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdentExpr(@NotNull Form2Parser.IdentExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogExpr(@NotNull Form2Parser.LogExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogExpr(@NotNull Form2Parser.LogExprContext ctx);

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
	 * Enter a parse tree produced by {@link Form2Parser#plusExpr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(@NotNull Form2Parser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#plusExpr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(@NotNull Form2Parser.PlusExprContext ctx);

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
	 * Enter a parse tree produced by {@link Form2Parser#compExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull Form2Parser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#compExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull Form2Parser.CompExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#structures}.
	 * @param ctx the parse tree
	 */
	void enterStructures(@NotNull Form2Parser.StructuresContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#structures}.
	 * @param ctx the parse tree
	 */
	void exitStructures(@NotNull Form2Parser.StructuresContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#intExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(@NotNull Form2Parser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#intExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(@NotNull Form2Parser.IntExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#wrapExpr}.
	 * @param ctx the parse tree
	 */
	void enterWrapExpr(@NotNull Form2Parser.WrapExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#wrapExpr}.
	 * @param ctx the parse tree
	 */
	void exitWrapExpr(@NotNull Form2Parser.WrapExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link Form2Parser#negExpr}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(@NotNull Form2Parser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Form2Parser#negExpr}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(@NotNull Form2Parser.NegExprContext ctx);

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