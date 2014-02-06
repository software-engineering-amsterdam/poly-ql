// Generated from Test.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull TestParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull TestParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link TestParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(@NotNull TestParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(@NotNull TestParser.InitContext ctx);
}