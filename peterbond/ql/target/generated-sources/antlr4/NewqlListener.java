// Generated from Newql.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NewqlParser}.
 */
public interface NewqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NewqlParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull NewqlParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link NewqlParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull NewqlParser.RContext ctx);
}