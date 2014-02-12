// Generated from Bye.g4 by ANTLR 4.1
package test;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ByeParser}.
 */
public interface ByeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ByeParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull ByeParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link ByeParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull ByeParser.RContext ctx);
}