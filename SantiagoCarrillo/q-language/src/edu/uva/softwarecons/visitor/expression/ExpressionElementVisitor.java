package edu.uva.softwarecons.visitor.expression;

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
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/5/14
 */
public interface ExpressionElementVisitor
{

    Type visitAddExpression( AddExpression expression );

    Type visitDivExpression( DivExpression expression );

    Type visitMulExpression( MulExpression expression );

    Type visitSubExpression( SubExpression expression );

    Type visitAndExpression( AndExpression expression );

    Type visitNotExpression( NotExpression expression );

    Type visitOrExpression( OrExpression expression );

    Type visitEqualExpression( EqualExpression expression );

    Type visitGreaterEqualExpression( GreaterEqualExpression expression );

    Type visitGreaterExpression( GreaterExpression expression );

    Type visitLessEqualExpression( LessEqualExpression expression );

    Type visitLessExpression( LessExpression expression );

    Type visitNotEqualExpression( NotEqualExpression expression );

    Type visitIdExpression( IdExpression expression );

}
