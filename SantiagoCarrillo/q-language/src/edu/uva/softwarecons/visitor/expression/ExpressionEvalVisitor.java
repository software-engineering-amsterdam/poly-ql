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
import edu.uva.softwarecons.model.expression.literal.BoolExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.value.Value;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public interface ExpressionEvalVisitor
{

    Value visitAddExpression( AddExpression expression );

    Value visitDivExpression( DivExpression expression );

    Value visitMulExpression( MulExpression expression );

    Value visitSubExpression( SubExpression expression );

    Value visitAndExpression( AndExpression expression );

    Value visitNotExpression( NotExpression expression );

    Value visitOrExpression( OrExpression expression );

    Value visitEqualExpression( EqualExpression expression );

    Value visitGreaterEqualExpression( GreaterEqualExpression expression );

    Value visitGreaterExpression( GreaterExpression expression );

    Value visitLessEqualExpression( LessEqualExpression expression );

    Value visitLessExpression( LessExpression expression );

    Value visitNotEqualExpression( NotEqualExpression expression );

    Value visitIdExpression( IdExpression expression );

    Value visitBoolExpression( BoolExpression expression );

    Value visitIntExpression( IntExpression expression );

}
