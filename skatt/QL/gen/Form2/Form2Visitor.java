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
	 * Visit a parse tree produced by {@link Form2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull Form2Parser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(@NotNull Form2Parser.StructureContext ctx);

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
	 * Visit a parse tree produced by {@link Form2Parser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull Form2Parser.QuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#ifcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfcondition(@NotNull Form2Parser.IfconditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link Form2Parser#elsecondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsecondition(@NotNull Form2Parser.ElseconditionContext ctx);
}