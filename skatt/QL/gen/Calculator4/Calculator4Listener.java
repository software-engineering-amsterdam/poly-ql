// Generated from C:\Users\Sammie\Documents\projects\u005Cuva\softcon\poly-ql\skatt\QL\src\grammars/Calculator4.g4 by ANTLR 4.2

package Calculator4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Calculator4Parser}.
 */
public interface Calculator4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull Calculator4Parser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull Calculator4Parser.ArgContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#addOrSubtract}.
	 * @param ctx the parse tree
	 */
	void enterAddOrSubtract(@NotNull Calculator4Parser.AddOrSubtractContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#addOrSubtract}.
	 * @param ctx the parse tree
	 */
	void exitAddOrSubtract(@NotNull Calculator4Parser.AddOrSubtractContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterMultOrDiv(@NotNull Calculator4Parser.MultOrDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitMultOrDiv(@NotNull Calculator4Parser.MultOrDivContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull Calculator4Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull Calculator4Parser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(@NotNull Calculator4Parser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(@NotNull Calculator4Parser.IntegerContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull Calculator4Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull Calculator4Parser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull Calculator4Parser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull Calculator4Parser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(@NotNull Calculator4Parser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(@NotNull Calculator4Parser.ParenExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull Calculator4Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull Calculator4Parser.IdentifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link Calculator4Parser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull Calculator4Parser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculator4Parser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull Calculator4Parser.PrintContext ctx);
}