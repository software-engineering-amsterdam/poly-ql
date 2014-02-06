// Generated from C:\Users\Sammie\Documents\projects\u005Cuva\softcon\poly-ql\skatt\QL\src\grammars/WordSeparation.g4 by ANTLR 4.2

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
}