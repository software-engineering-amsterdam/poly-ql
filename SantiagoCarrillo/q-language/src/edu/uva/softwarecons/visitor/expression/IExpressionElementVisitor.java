package edu.uva.softwarecons.visitor.expression;

import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.expression.IntExpression;
import edu.uva.softwarecons.model.expression.ParenthesisExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/5/14
 */
public interface IExpressionElementVisitor {

    void visitAddExpression(AddExpression expression);

    void visitDivExpression(DivExpression expression);

    void visitMulExpression(MulExpression expression);

    void visitSubExpression(SubExpression expression);

    void visitAndExpression(AndExpression expression);

    void visitNotExpression(NotExpression expression);

    void visitOrExpression(OrExpression expression);

    void visitEqualExpression(EqualExpression expression);

    void visitGreaterEqualExpression(GreaterEqualExpression expression);

    void visitGreaterExpression(GreaterExpression expression);

    void visitLessEqualExpression(LessEqualExpression expression);

    void visitLessExpression(LessExpression expression);

    void visitNotEqualExpression(NotEqualExpression expression);

    void visitIdExpression(IdExpression expression);

    void visitIntExpression(IntExpression expression);

    void visitParenthesisExpression(ParenthesisExpression expression);
}
