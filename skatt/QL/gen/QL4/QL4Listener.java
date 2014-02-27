// Generated from grammar/QL4.g4 by ANTLR 4.2

	package QL4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QL4Parser}.
 */
public interface QL4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QL4Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(@NotNull QL4Parser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(@NotNull QL4Parser.MultExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#greExpr}.
	 * @param ctx the parse tree
	 */
	void enterGreExpr(@NotNull QL4Parser.GreExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#greExpr}.
	 * @param ctx the parse tree
	 */
	void exitGreExpr(@NotNull QL4Parser.GreExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull QL4Parser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull QL4Parser.AndExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#geqExpr}.
	 * @param ctx the parse tree
	 */
	void enterGeqExpr(@NotNull QL4Parser.GeqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#geqExpr}.
	 * @param ctx the parse tree
	 */
	void exitGeqExpr(@NotNull QL4Parser.GeqExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#elseifcondition}.
	 * @param ctx the parse tree
	 */
	void enterElseifcondition(@NotNull QL4Parser.ElseifconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#elseifcondition}.
	 * @param ctx the parse tree
	 */
	void exitElseifcondition(@NotNull QL4Parser.ElseifconditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#lesExpr}.
	 * @param ctx the parse tree
	 */
	void enterLesExpr(@NotNull QL4Parser.LesExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#lesExpr}.
	 * @param ctx the parse tree
	 */
	void exitLesExpr(@NotNull QL4Parser.LesExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#plusExpr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(@NotNull QL4Parser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#plusExpr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(@NotNull QL4Parser.PlusExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#regQuestion}.
	 * @param ctx the parse tree
	 */
	void enterRegQuestion(@NotNull QL4Parser.RegQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#regQuestion}.
	 * @param ctx the parse tree
	 */
	void exitRegQuestion(@NotNull QL4Parser.RegQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#compQuestion}.
	 * @param ctx the parse tree
	 */
	void enterCompQuestion(@NotNull QL4Parser.CompQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#compQuestion}.
	 * @param ctx the parse tree
	 */
	void exitCompQuestion(@NotNull QL4Parser.CompQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(@NotNull QL4Parser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(@NotNull QL4Parser.DecContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#minExpr}.
	 * @param ctx the parse tree
	 */
	void enterMinExpr(@NotNull QL4Parser.MinExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#minExpr}.
	 * @param ctx the parse tree
	 */
	void exitMinExpr(@NotNull QL4Parser.MinExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(@NotNull QL4Parser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(@NotNull QL4Parser.IdentContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#workflowStruct}.
	 * @param ctx the parse tree
	 */
	void enterWorkflowStruct(@NotNull QL4Parser.WorkflowStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#workflowStruct}.
	 * @param ctx the parse tree
	 */
	void exitWorkflowStruct(@NotNull QL4Parser.WorkflowStructContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#neqExpr}.
	 * @param ctx the parse tree
	 */
	void enterNeqExpr(@NotNull QL4Parser.NeqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#neqExpr}.
	 * @param ctx the parse tree
	 */
	void exitNeqExpr(@NotNull QL4Parser.NeqExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(@NotNull QL4Parser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(@NotNull QL4Parser.EqExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void enterElsecondition(@NotNull QL4Parser.ElseconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void exitElsecondition(@NotNull QL4Parser.ElseconditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#divExpr}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(@NotNull QL4Parser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#divExpr}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(@NotNull QL4Parser.DivExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QL4Parser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QL4Parser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull QL4Parser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull QL4Parser.IntContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void enterIfcondition(@NotNull QL4Parser.IfconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void exitIfcondition(@NotNull QL4Parser.IfconditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#questionStruct}.
	 * @param ctx the parse tree
	 */
	void enterQuestionStruct(@NotNull QL4Parser.QuestionStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#questionStruct}.
	 * @param ctx the parse tree
	 */
	void exitQuestionStruct(@NotNull QL4Parser.QuestionStructContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#structures}.
	 * @param ctx the parse tree
	 */
	void enterStructures(@NotNull QL4Parser.StructuresContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#structures}.
	 * @param ctx the parse tree
	 */
	void exitStructures(@NotNull QL4Parser.StructuresContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull QL4Parser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull QL4Parser.OrExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#wrapExpr}.
	 * @param ctx the parse tree
	 */
	void enterWrapExpr(@NotNull QL4Parser.WrapExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#wrapExpr}.
	 * @param ctx the parse tree
	 */
	void exitWrapExpr(@NotNull QL4Parser.WrapExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#leqExpr}.
	 * @param ctx the parse tree
	 */
	void enterLeqExpr(@NotNull QL4Parser.LeqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#leqExpr}.
	 * @param ctx the parse tree
	 */
	void exitLeqExpr(@NotNull QL4Parser.LeqExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#negExpr}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(@NotNull QL4Parser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#negExpr}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(@NotNull QL4Parser.NegExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link QL4Parser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull QL4Parser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link QL4Parser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull QL4Parser.BoolContext ctx);
}