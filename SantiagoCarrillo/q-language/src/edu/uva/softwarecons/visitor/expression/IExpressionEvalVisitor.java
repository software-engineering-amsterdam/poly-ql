package edu.uva.softwarecons.visitor.expression;

import edu.uva.softwarecons.exception.CompareException;
import edu.uva.softwarecons.exception.InvalidOperationException;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.expression.literal.BoolExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.value.Value;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public interface IExpressionEvalVisitor {

    Value visitAddExpression(AddExpression expression) throws CompareException;

    Value visitDivExpression(DivExpression expression) throws CompareException;

    Value visitMulExpression(MulExpression expression) throws CompareException;

    Value visitSubExpression(SubExpression expression) throws CompareException;

    Value visitAndExpression(AndExpression expression) throws CompareException;

    Value visitNotExpression(NotExpression expression) throws CompareException;

    Value visitOrExpression(OrExpression expression) throws CompareException;

    Value visitEqualExpression(EqualExpression expression) throws CompareException;

    Value visitGreaterEqualExpression(GreaterEqualExpression expression) throws CompareException;

    Value visitGreaterExpression(GreaterExpression expression) throws CompareException;

    Value visitLessEqualExpression(LessEqualExpression expression) throws CompareException;

    Value visitLessExpression(LessExpression expression) throws CompareException;

    Value visitNotEqualExpression(NotEqualExpression expression) throws CompareException;

    Value visitIdExpression(IdExpression expression);

    Value visitBoolExpression(BoolExpression expression);

    Value visitIntExpression(IntExpression expression);

}
