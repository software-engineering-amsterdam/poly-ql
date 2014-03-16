// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link QuestionnaireVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public class QuestionnaireBaseVisitor<T>
    extends AbstractParseTreeVisitor<T>
    implements QuestionnaireVisitor<T>
{
    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitElse( @NotNull QuestionnaireParser.ElseContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitSimpleQuestion( @NotNull QuestionnaireParser.SimpleQuestionContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitStringType( @NotNull QuestionnaireParser.StringTypeContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitDecimalType( @NotNull QuestionnaireParser.DecimalTypeContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBooleanType( @NotNull QuestionnaireParser.BooleanTypeContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitComputedQuestion( @NotNull QuestionnaireParser.ComputedQuestionContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitInteger( @NotNull QuestionnaireParser.IntegerContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitOr( @NotNull QuestionnaireParser.OrContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitCompare( @NotNull QuestionnaireParser.CompareContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitMulDiv( @NotNull QuestionnaireParser.MulDivContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIntType( @NotNull QuestionnaireParser.IntTypeContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitDateType( @NotNull QuestionnaireParser.DateTypeContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitAnd( @NotNull QuestionnaireParser.AndContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitId( @NotNull QuestionnaireParser.IdContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitNot( @NotNull QuestionnaireParser.NotContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitQuestionnaire( @NotNull QuestionnaireParser.QuestionnaireContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIf( @NotNull QuestionnaireParser.IfContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitString( @NotNull QuestionnaireParser.StringContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitAddSub( @NotNull QuestionnaireParser.AddSubContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBoolean( @NotNull QuestionnaireParser.BooleanContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitParenthesis( @NotNull QuestionnaireParser.ParenthesisContext ctx )
    {
        return visitChildren( ctx );
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitMoneyType( @NotNull QuestionnaireParser.MoneyTypeContext ctx )
    {
        return visitChildren( ctx );
    }
}