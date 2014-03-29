package edu.uva.softwarecons.grammar;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.EqualExpression;
import edu.uva.softwarecons.model.expression.comparison.GreaterEqualExpression;
import edu.uva.softwarecons.model.expression.comparison.GreaterExpression;
import edu.uva.softwarecons.model.expression.comparison.LessEqualExpression;
import edu.uva.softwarecons.model.expression.comparison.LessExpression;
import edu.uva.softwarecons.model.expression.comparison.NotEqualExpression;
import edu.uva.softwarecons.model.expression.literal.BoolExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.expression.literal.StringExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.ElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.DecimalType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.MoneyType;
import edu.uva.softwarecons.model.type.StringType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.QuestionnaireElement;
import edu.uva.softwarecons.visitor.form.FormElement;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/26/14
 */
public class QuestionnaireBuilderVisitor
    extends QuestionnaireBaseVisitor<QuestionnaireElement>
{

    @Override
    public FormElement visitQuestionnaire( @NotNull QuestionnaireParser.QuestionnaireContext ctx )
    {
        List<Question> questions = new ArrayList<Question>();
        for ( QuestionnaireParser.QuestionContext question : ctx.question() )
        {
            questions.add( (Question) question.accept( this ) );
        }
        return new Form( ctx.ID().getText(), questions );
    }

    @Override
    public BasicQuestion visitSimpleQuestion( @NotNull QuestionnaireParser.SimpleQuestionContext ctx )
    {
        return new BasicQuestion( ctx.ID().getText(), ctx.STRING().getText(), (Type) ctx.type().accept( this ) );
    }

    @Override
    public ComputedQuestion visitComputedQuestion( @NotNull QuestionnaireParser.ComputedQuestionContext ctx )
    {
        return new ComputedQuestion( ctx.ID().getText(), ctx.STRING().getText(), (Type) ctx.type().accept( this ),
                                     (Expression) ctx.expr().accept( this ) );
    }

    @Override
    public IfQuestion visitIf( @NotNull QuestionnaireParser.IfContext ctx )
    {
        List<Question> questions = new ArrayList<Question>();
        for ( QuestionnaireParser.QuestionContext q : ctx.question() )
        {
            questions.add( (Question) q.accept( this ) );
        }
        ElseQuestion elseQuestion = null;
        if ( null != ctx.elsestat() )
        {
            elseQuestion = (ElseQuestion) ctx.elsestat().accept( this );
        }
        return new IfQuestion( (Expression) ctx.expr().accept( this ), questions, elseQuestion, ctx.expr().getText() );
    }

    @Override
    public ElseQuestion visitElse( @NotNull QuestionnaireParser.ElseContext ctx )
    {
        List<Question> questions = new ArrayList<Question>();
        for ( QuestionnaireParser.QuestionContext q : ctx.question() )
        {
            questions.add( (BasicQuestion) q.accept( this ) );
        }
        return new ElseQuestion( questions );

    }

    @Override
    public BooleanType visitBooleanType( @NotNull QuestionnaireParser.BooleanTypeContext ctx )
    {
        return new BooleanType();
    }

    @Override
    public DateType visitDateType( @NotNull QuestionnaireParser.DateTypeContext ctx )
    {
        return new DateType();
    }

    @Override
    public DecimalType visitDecimalType( @NotNull QuestionnaireParser.DecimalTypeContext ctx )
    {
        return new DecimalType();
    }

    @Override
    public IntegerType visitIntType( @NotNull QuestionnaireParser.IntTypeContext ctx )
    {
        return new IntegerType();
    }

    @Override
    public MoneyType visitMoneyType( @NotNull QuestionnaireParser.MoneyTypeContext ctx )
    {
        return new MoneyType();
    }

    @Override
    public StringType visitStringType( @NotNull QuestionnaireParser.StringTypeContext ctx )
    {
        return new StringType();
    }

    @Override
    public Expression visitMulDiv( @NotNull QuestionnaireParser.MulDivContext ctx )
    {
        if ( null != ctx.MUL() )
        {
            return new MulExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                      (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        if ( null != ctx.DIV() )
        {
            return new DivExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                      (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        assert false : "BUG: unknown MulDiv argument";
        return null;
    }

    @Override
    public Expression visitAddSub( @NotNull QuestionnaireParser.AddSubContext ctx )
    {
        if ( null != ctx.SUB() )
        {
            return new SubExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                      (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        if ( null != ctx.SUB() )
        {
            return new AddExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                      (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        assert false : "BUG: unknown AddSub argument";
        return null;
    }

    //TODO fix bad smell !!
    @Override
    public Expression visitCompare( @NotNull QuestionnaireParser.CompareContext ctx )
    {
        if ( null != ctx.Eq() )
        {
            return new EqualExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                        (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        if ( null != ctx.GEq() )
        {
            return new GreaterEqualExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                               (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        if ( null != ctx.GT() )
        {
            return new GreaterExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                          (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        if ( null != ctx.LEq() )
        {
            return new LessEqualExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                            (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        if ( null != ctx.LT() )
        {
            return new LessExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                       (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        if ( null != ctx.NEq() )
        {
            return new NotEqualExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                           (Expression) ctx.expr().get( 1 ).accept( this ) );
        }
        assert false : "BUG: unknown compare argument";
        return null;
    }


    @Override
    public AndExpression visitAnd( @NotNull QuestionnaireParser.AndContext ctx )
    {
        return new AndExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                  (Expression) ctx.expr().get( 1 ).accept( this ) );
    }

    @Override
    public NotExpression visitNot( @NotNull QuestionnaireParser.NotContext ctx )
    {
        return new NotExpression( (Expression) ctx.expr().accept( this ) );
    }

    @Override
    public OrExpression visitOr( @NotNull QuestionnaireParser.OrContext ctx )
    {
        return new OrExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
                                 (Expression) ctx.expr().get( 1 ).accept( this ) );
    }

    @Override
    public BoolExpression visitBoolean( @NotNull QuestionnaireParser.BooleanContext ctx )
    {
        return new BoolExpression( Boolean.valueOf( ctx.getText() ) );
    }

    @Override
    public IdExpression visitId( @NotNull QuestionnaireParser.IdContext ctx )
    {
        return new IdExpression( ctx.ID().getText() );
    }

    @Override
    public IntExpression visitInteger( @NotNull QuestionnaireParser.IntegerContext ctx )
    {
        return new IntExpression( Integer.parseInt( ctx.getText() ) );
    }

    @Override
    public StringExpression visitString( @NotNull QuestionnaireParser.StringContext ctx )
    {
        return new StringExpression( ctx.getText() );
    }

    @Override
    public Expression visitParenthesis( @NotNull QuestionnaireParser.ParenthesisContext ctx )
    {
        return (Expression) ctx.expr().accept( this );

    }


}
