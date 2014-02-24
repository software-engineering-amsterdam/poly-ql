// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SinansGrammerParser}.
 */
public interface SinansGrammerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SinansGrammerParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull SinansGrammerParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link SinansGrammerParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull SinansGrammerParser.FormContext ctx);

	/**
	 * Enter a parse tree produced by {@link SinansGrammerParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(@NotNull SinansGrammerParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SinansGrammerParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(@NotNull SinansGrammerParser.ItemContext ctx);

	/**
	 * Enter a parse tree produced by {@link SinansGrammerParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(@NotNull SinansGrammerParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SinansGrammerParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(@NotNull SinansGrammerParser.ConditionalContext ctx);

	/**
	 * Enter a parse tree produced by {@link SinansGrammerParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull SinansGrammerParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SinansGrammerParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull SinansGrammerParser.QuestionContext ctx);
}