// Generated from grammar/WordSeparation.g4 by ANTLR 4.2

package WordSeparation;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WordSeparationParser}.
 */
public interface WordSeparationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WordSeparationParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull WordSeparationParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WordSeparationParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull WordSeparationParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link WordSeparationParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(@NotNull WordSeparationParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link WordSeparationParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(@NotNull WordSeparationParser.PartContext ctx);

	/**
	 * Enter a parse tree produced by {@link WordSeparationParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(@NotNull WordSeparationParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link WordSeparationParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(@NotNull WordSeparationParser.EndContext ctx);
}