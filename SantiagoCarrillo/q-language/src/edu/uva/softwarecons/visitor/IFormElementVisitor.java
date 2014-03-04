package edu.uva.softwarecons.visitor;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.expression.IntExpression;
import edu.uva.softwarecons.model.expression.ParenthesisExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.bool.AndExpression;
import edu.uva.softwarecons.model.expression.bool.NotExpression;
import edu.uva.softwarecons.model.expression.bool.OrExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.*;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public interface IFormElementVisitor {

    void visitForm(Form form);

    void visitComputedQuestion(ComputedQuestion question);

    void visitIfElseQuestion(IfElseQuestion question);

    void visitIfQuestion(IfQuestion question);

    void visitQuestion(Question question);

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

    void visitBooleanType(BooleanType type);

    void visitDateType(DateType type);

    void visitDecimalType(DecimalType type);

    void visitIntegerType(IntegerType type);

    void visitMoneyType(MoneyType type);

    void visitStringType(StringType type);


}
