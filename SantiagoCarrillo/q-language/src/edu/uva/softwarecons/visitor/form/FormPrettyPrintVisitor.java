package edu.uva.softwarecons.visitor.form;

import edu.uva.softwarecons.model.Form;
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
import edu.uva.softwarecons.model.expression.literal.IdExpression;
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
import edu.uva.softwarecons.visitor.expression.ExpressionElementVisitor;
import edu.uva.softwarecons.visitor.type.TypeElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/26/14
 */
public class FormPrettyPrintVisitor
    implements FormElementVisitor, ExpressionElementVisitor, TypeElementVisitor
{


    @Override
    public void visitForm( Form form )
    {
        System.out.print( "form " + form.getId() + "{\n" );
        for ( Question question : form.getQuestions() )
        {
            question.accept( this );
        }
        System.out.print( "\n}" );
    }

    @Override
    public void visitQuestion( BasicQuestion question )
    {
        System.out.print( "\t\t" );
        System.out.print( question );
        System.out.print( "\n" );
    }


    @Override
    public void visitComputedQuestion( ComputedQuestion question )
    {
        System.out.print( "\t\t" );
        System.out.print( question );
        question.getExpression().accept( this );
        System.out.print( ")\n" );
    }

    @Override
    public void visitIfQuestion( IfQuestion question )
    {
        System.out.print( "\t" );
        System.out.print( "if(" );
        question.getExpression().accept( this );
        System.out.print( "){" );
        System.out.print( "\n" );
        for ( Question q : question.getQuestions() )
        {
            q.accept( this );
        }
        System.out.print( "\t}" );
        if ( null != question.getElseQuestion() )
        {
            question.getElseQuestion().accept( this );
        }

    }

    @Override
    public void visitElseQuestion( ElseQuestion question )
    {
        System.out.print( "else{\n" );
        for ( Question q : question.getQuestions() )
        {
            q.accept( this );
        }
        System.out.print( "\t}\n" );
    }

    @Override
    public void visitBooleanType( BooleanType type )
    {
        System.out.print( type );
    }

    @Override
    public void visitDateType( DateType type )
    {
        System.out.print( type );
    }

    @Override
    public void visitDecimalType( DecimalType type )
    {
        System.out.print( type );
    }

    @Override
    public void visitIntegerType( IntegerType type )
    {
        System.out.print( type );
    }

    @Override
    public void visitMoneyType( MoneyType type )
    {
        System.out.print( type );
    }

    @Override
    public void visitStringType( StringType type )
    {
        System.out.print( type );
    }


    @Override
    public Type visitAddExpression( AddExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " + " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitDivExpression( DivExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " / " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitMulExpression( MulExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " * " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitSubExpression( SubExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " - " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitAndExpression( AndExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " && " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitOrExpression( OrExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " || " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitEqualExpression( EqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " == " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitGreaterEqualExpression( GreaterEqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " >= " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitGreaterExpression( GreaterExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " > " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitLessEqualExpression( LessEqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " <= " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitLessExpression( LessExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " < " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitNotEqualExpression( NotEqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        System.out.print( " != " );
        expression.getRightExpression().accept( this );
        return null;
    }

    @Override
    public Type visitNotExpression( NotExpression expression )
    {
        System.out.print( "!" );
        expression.getArgument().accept( this );
        return null;
    }


    @Override
    public Type visitIdExpression( IdExpression expression )
    {
        System.out.print( expression.getId() );
        return null;
    }


}
