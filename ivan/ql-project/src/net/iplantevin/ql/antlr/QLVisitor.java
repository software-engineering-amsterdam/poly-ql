// Generated from QL.g4 by ANTLR 4.2
package net.iplantevin.ql.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link QLParser#ifElse}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfElse(@NotNull QLParser.IfElseContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlock(@NotNull QLParser.BlockContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#intType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntType(@NotNull QLParser.IntTypeContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#unary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnary(@NotNull QLParser.UnaryContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#equality}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEquality(@NotNull QLParser.EqualityContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#multiplication}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMultiplication(@NotNull QLParser.MultiplicationContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#if}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIf(@NotNull QLParser.IfContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#false}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFalse(@NotNull QLParser.FalseContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#blockStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlockStat(@NotNull QLParser.BlockStatContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#logicalOr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicalOr(@NotNull QLParser.LogicalOrContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#boolean}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolean(@NotNull QLParser.BooleanContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#question}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQuestion(@NotNull QLParser.QuestionContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#strType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStrType(@NotNull QLParser.StrTypeContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#forms}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForms(@NotNull QLParser.FormsContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#parantheses}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParantheses(@NotNull QLParser.ParanthesesContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#logicalAnd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicalAnd(@NotNull QLParser.LogicalAndContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#form}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForm(@NotNull QLParser.FormContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#integer}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInteger(@NotNull QLParser.IntegerContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#true}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTrue(@NotNull QLParser.TrueContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#addition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddition(@NotNull QLParser.AdditionContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#boolType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolType(@NotNull QLParser.BoolTypeContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#string}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString(@NotNull QLParser.StringContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#relational}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRelational(@NotNull QLParser.RelationalContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#computation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComputation(@NotNull QLParser.ComputationContext ctx);

    /**
     * Visit a parse tree produced by {@link QLParser#identifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifier(@NotNull QLParser.IdentifierContext ctx);
}