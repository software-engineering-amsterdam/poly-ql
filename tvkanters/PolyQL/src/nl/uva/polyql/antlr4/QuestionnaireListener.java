// Generated from Questionnaire.g4 by ANTLR 4.1

    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.ast.*;
    import nl.uva.polyql.ast.expressions.*;
    import nl.uva.polyql.ast.expressions.operations.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionnaireParser}.
 */
public interface QuestionnaireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_or}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or(@NotNull QuestionnaireParser.Expr_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_or}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or(@NotNull QuestionnaireParser.Expr_orContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QuestionnaireParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QuestionnaireParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#op_num}.
	 * @param ctx the parse tree
	 */
	void enterOp_num(@NotNull QuestionnaireParser.Op_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#op_num}.
	 * @param ctx the parse tree
	 */
	void exitOp_num(@NotNull QuestionnaireParser.Op_numContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#calcquestion}.
	 * @param ctx the parse tree
	 */
	void enterCalcquestion(@NotNull QuestionnaireParser.CalcquestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#calcquestion}.
	 * @param ctx the parse tree
	 */
	void exitCalcquestion(@NotNull QuestionnaireParser.CalcquestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_num}.
	 * @param ctx the parse tree
	 */
	void enterExpr_num(@NotNull QuestionnaireParser.Expr_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_num}.
	 * @param ctx the parse tree
	 */
	void exitExpr_num(@NotNull QuestionnaireParser.Expr_numContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_unary}.
	 * @param ctx the parse tree
	 */
	void enterExpr_unary(@NotNull QuestionnaireParser.Expr_unaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_unary}.
	 * @param ctx the parse tree
	 */
	void exitExpr_unary(@NotNull QuestionnaireParser.Expr_unaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_sum}.
	 * @param ctx the parse tree
	 */
	void enterExpr_sum(@NotNull QuestionnaireParser.Expr_sumContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_sum}.
	 * @param ctx the parse tree
	 */
	void exitExpr_sum(@NotNull QuestionnaireParser.Expr_sumContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#op_sum}.
	 * @param ctx the parse tree
	 */
	void enterOp_sum(@NotNull QuestionnaireParser.Op_sumContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#op_sum}.
	 * @param ctx the parse tree
	 */
	void exitOp_sum(@NotNull QuestionnaireParser.Op_sumContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#op_prod}.
	 * @param ctx the parse tree
	 */
	void enterOp_prod(@NotNull QuestionnaireParser.Op_prodContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#op_prod}.
	 * @param ctx the parse tree
	 */
	void exitOp_prod(@NotNull QuestionnaireParser.Op_prodContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#op_unary}.
	 * @param ctx the parse tree
	 */
	void enterOp_unary(@NotNull QuestionnaireParser.Op_unaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#op_unary}.
	 * @param ctx the parse tree
	 */
	void exitOp_unary(@NotNull QuestionnaireParser.Op_unaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_prod}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prod(@NotNull QuestionnaireParser.Expr_prodContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_prod}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prod(@NotNull QuestionnaireParser.Expr_prodContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_main}.
	 * @param ctx the parse tree
	 */
	void enterExpr_main(@NotNull QuestionnaireParser.Expr_mainContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_main}.
	 * @param ctx the parse tree
	 */
	void exitExpr_main(@NotNull QuestionnaireParser.Expr_mainContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#op_eq}.
	 * @param ctx the parse tree
	 */
	void enterOp_eq(@NotNull QuestionnaireParser.Op_eqContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#op_eq}.
	 * @param ctx the parse tree
	 */
	void exitOp_eq(@NotNull QuestionnaireParser.Op_eqContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#op_and}.
	 * @param ctx the parse tree
	 */
	void enterOp_and(@NotNull QuestionnaireParser.Op_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#op_and}.
	 * @param ctx the parse tree
	 */
	void exitOp_and(@NotNull QuestionnaireParser.Op_andContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void enterExpr_eq(@NotNull QuestionnaireParser.Expr_eqContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void exitExpr_eq(@NotNull QuestionnaireParser.Expr_eqContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_and}.
	 * @param ctx the parse tree
	 */
	void enterExpr_and(@NotNull QuestionnaireParser.Expr_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_and}.
	 * @param ctx the parse tree
	 */
	void exitExpr_and(@NotNull QuestionnaireParser.Expr_andContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(@NotNull QuestionnaireParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(@NotNull QuestionnaireParser.IfstatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#op_or}.
	 * @param ctx the parse tree
	 */
	void enterOp_or(@NotNull QuestionnaireParser.Op_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#op_or}.
	 * @param ctx the parse tree
	 */
	void exitOp_or(@NotNull QuestionnaireParser.Op_orContext ctx);

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
	 * Enter a parse tree produced by {@link QuestionnaireParser#expr_atom}.
	 * @param ctx the parse tree
	 */
	void enterExpr_atom(@NotNull QuestionnaireParser.Expr_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#expr_atom}.
	 * @param ctx the parse tree
	 */
	void exitExpr_atom(@NotNull QuestionnaireParser.Expr_atomContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#formrule}.
	 * @param ctx the parse tree
	 */
	void enterFormrule(@NotNull QuestionnaireParser.FormruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#formrule}.
	 * @param ctx the parse tree
	 */
	void exitFormrule(@NotNull QuestionnaireParser.FormruleContext ctx);
}