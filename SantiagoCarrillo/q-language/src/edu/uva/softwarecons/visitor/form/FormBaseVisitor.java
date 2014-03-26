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
 *         Date: 2/27/14
 */
public class FormBaseVisitor
    implements FormElementVisitor, ExpressionElementVisitor, TypeElementVisitor
{


    @Override
    public void visitForm( Form form )
    {

    }

    @Override
    public void visitComputedQuestion( ComputedQuestion question )
    {

    }

    @Override
    public void visitIfQuestion( IfQuestion question )
    {

    }

    @Override
    public void visitElseQuestion( ElseQuestion question )
    {

    }

    @Override
    public void visitQuestion( BasicQuestion question )
    {

    }


    @Override
    public void visitBooleanType( BooleanType type )
    {

    }

    @Override
    public void visitDateType( DateType type )
    {

    }

    @Override
    public void visitDecimalType( DecimalType type )
    {

    }

    @Override
    public void visitIntegerType( IntegerType type )
    {

    }

    @Override
    public void visitMoneyType( MoneyType type )
    {

    }

    @Override
    public void visitStringType( StringType type )
    {

    }

    @Override
    public Type visitAddExpression( AddExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitDivExpression( DivExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitMulExpression( MulExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitSubExpression( SubExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitAndExpression( AndExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitOrExpression( OrExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitEqualExpression( EqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitGreaterEqualExpression( GreaterEqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitGreaterExpression( GreaterExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitLessEqualExpression( LessEqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitLessExpression( LessExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitNotEqualExpression( NotEqualExpression expression )
    {
        expression.getLeftExpression().accept( this );
        return expression.getRightExpression().accept( this );
    }

    @Override
    public Type visitIdExpression( IdExpression expression )
    {
        return null;
    }

    @Override
    public Type visitNotExpression( NotExpression expression )
    {
        return expression.getArgument().accept( this );
    }


}
