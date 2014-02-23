// Generated from grammar/Form2.g4 by ANTLR 4.2

	package Form2;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Form2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Form2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Form2Parser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(@NotNull Form2Parser.MultExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(@NotNull Form2Parser.StructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#identExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentExpr(@NotNull Form2Parser.IdentExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogExpr(@NotNull Form2Parser.LogExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull Form2Parser.FormContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#elseifcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifcondition(@NotNull Form2Parser.ElseifconditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(@NotNull Form2Parser.LabelContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#plusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(@NotNull Form2Parser.PlusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#ifcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfcondition(@NotNull Form2Parser.IfconditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#compExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(@NotNull Form2Parser.CompExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#structures}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructures(@NotNull Form2Parser.StructuresContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#intExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(@NotNull Form2Parser.IntExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#wrapExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrapExpr(@NotNull Form2Parser.WrapExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#negExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(@NotNull Form2Parser.NegExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull Form2Parser.QuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#elsecondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsecondition(@NotNull Form2Parser.ElseconditionContext ctx);
}