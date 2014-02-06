// Generated from Newql.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NewqlParser}.
 */
public interface NewqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NewqlParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull NewqlParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link NewqlParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull NewqlParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link NewqlParser#hallon}.
	 * @param ctx the parse tree
	 */
	void enterHallon(@NotNull NewqlParser.HallonContext ctx);
	/**
	 * Exit a parse tree produced by {@link NewqlParser#hallon}.
	 * @param ctx the parse tree
	 */
	void exitHallon(@NotNull NewqlParser.HallonContext ctx);
}