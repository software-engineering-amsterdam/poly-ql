// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionnaireParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface QuestionnaireVisitor<T>
    extends ParseTreeVisitor<T>
{
    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#else}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitElse( @NotNull QuestionnaireParser.ElseContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#simpleQuestion}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleQuestion( @NotNull QuestionnaireParser.SimpleQuestionContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#stringType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStringType( @NotNull QuestionnaireParser.StringTypeContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#decimalType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDecimalType( @NotNull QuestionnaireParser.DecimalTypeContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#booleanType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanType( @NotNull QuestionnaireParser.BooleanTypeContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#computedQuestion}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComputedQuestion( @NotNull QuestionnaireParser.ComputedQuestionContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#integer}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInteger( @NotNull QuestionnaireParser.IntegerContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#or}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOr( @NotNull QuestionnaireParser.OrContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#compare}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCompare( @NotNull QuestionnaireParser.CompareContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#mulDiv}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMulDiv( @NotNull QuestionnaireParser.MulDivContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#intType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntType( @NotNull QuestionnaireParser.IntTypeContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#dateType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDateType( @NotNull QuestionnaireParser.DateTypeContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#and}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAnd( @NotNull QuestionnaireParser.AndContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#id}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitId( @NotNull QuestionnaireParser.IdContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#not}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNot( @NotNull QuestionnaireParser.NotContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQuestionnaire( @NotNull QuestionnaireParser.QuestionnaireContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#if}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIf( @NotNull QuestionnaireParser.IfContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#string}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString( @NotNull QuestionnaireParser.StringContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#addSub}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddSub( @NotNull QuestionnaireParser.AddSubContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#boolean}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolean( @NotNull QuestionnaireParser.BooleanContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#parenthesis}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParenthesis( @NotNull QuestionnaireParser.ParenthesisContext ctx );

    /**
     * Visit a parse tree produced by {@link QuestionnaireParser#moneyType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMoneyType( @NotNull QuestionnaireParser.MoneyTypeContext ctx );
}