// Generated from QL.g4 by ANTLR 4.2

package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.stat.*;
import ql.ast.form.*;
import ql.ast.form.QuestionType.*;
import ql.ast.expr.ExprType.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QLParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#formItems}.
	 * @param ctx the parse tree
	 */
	void enterFormItems(@NotNull QLParser.FormItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#formItems}.
	 * @param ctx the parse tree
	 */
	void exitFormItems(@NotNull QLParser.FormItemsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QLParser.QuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull QLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull QLParser.TypeContext ctx);
}