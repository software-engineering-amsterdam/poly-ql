package edu.uva.softwarecons.visitor.expression;

import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/5/14
 */
public interface IExpressionElementVisitor {

    Type visitAddExpression(AddExpression expression);

    Type visitDivExpression(DivExpression expression);

    Type visitMulExpression(MulExpression expression);

    Type visitSubExpression(SubExpression expression);

    Type visitAndExpression(AndExpression expression);

    Type visitNotExpression(NotExpression expression);

    Type visitOrExpression(OrExpression expression);

    Type visitEqualExpression(EqualExpression expression);

    Type visitGreaterEqualExpression(GreaterEqualExpression expression);

    Type visitGreaterExpression(GreaterExpression expression);

    Type visitLessEqualExpression(LessEqualExpression expression);

    Type visitLessExpression(LessExpression expression);

    Type visitNotEqualExpression(NotEqualExpression expression);

    Type visitIdExpression(IdExpression expression);

}
