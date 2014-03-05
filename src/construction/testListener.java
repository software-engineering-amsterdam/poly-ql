/* 
 * Copyright (C) 2014 svene_000
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package construction;
import java.util.HashMap;
import java.util.ArrayList;
import construction.Operators.*;
import construction.Types.*;
import construction.QuestionElements.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link testParser}.
 */
public interface testListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link testParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull testParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull testParser.ExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link testParser#questionaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionaire(@NotNull testParser.QuestionaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#questionaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionaire(@NotNull testParser.QuestionaireContext ctx);

	/**
	 * Enter a parse tree produced by {@link testParser#questionentry}.
	 * @param ctx the parse tree
	 */
	void enterQuestionentry(@NotNull testParser.QuestionentryContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#questionentry}.
	 * @param ctx the parse tree
	 */
	void exitQuestionentry(@NotNull testParser.QuestionentryContext ctx);

	/**
	 * Enter a parse tree produced by {@link testParser#computed}.
	 * @param ctx the parse tree
	 */
	void enterComputed(@NotNull testParser.ComputedContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#computed}.
	 * @param ctx the parse tree
	 */
	void exitComputed(@NotNull testParser.ComputedContext ctx);

	/**
	 * Enter a parse tree produced by {@link testParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(@NotNull testParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(@NotNull testParser.ItemContext ctx);

	/**
	 * Enter a parse tree produced by {@link testParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(@NotNull testParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(@NotNull testParser.ConditionalContext ctx);

	/**
	 * Enter a parse tree produced by {@link testParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull testParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull testParser.TypeContext ctx);
}