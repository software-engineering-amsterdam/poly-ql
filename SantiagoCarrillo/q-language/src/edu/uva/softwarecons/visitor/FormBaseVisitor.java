package edu.uva.softwarecons.visitor;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.IdExpression;
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
 * Date: 2/27/14
 */
public class FormBaseVisitor implements IFormElementVisitor{


    @Override
    public void visitForm(Form form) {

    }

    @Override
    public void visitComputedQuestion(ComputedQuestion question) {

    }

    @Override
    public void visitIfElseQuestion(IfElseQuestion question) {

    }

    @Override
    public void visitIfQuestion(IfQuestion question) {

    }

    @Override
    public void visitQuestion(Question question) {

    }

    @Override
    public void visitAddExpression(AddExpression expression) {

    }

    @Override
    public void visitDivExpression(DivExpression expression) {

    }

    @Override
    public void visitMulExpression(MulExpression expression) {

    }

    @Override
    public void visitSubExpression(SubExpression expression) {

    }

    @Override
    public void visitAndExpression(AndExpression expression) {

    }

    @Override
    public void visitNotExpression(NotExpression expression) {

    }

    @Override
    public void visitOrExpression(OrExpression expression) {

    }

    @Override
    public void visitEqualExpression(EqualExpression expression) {

    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {

    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {

    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {

    }

    @Override
    public void visitLessExpression(LessExpression expression) {

    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {

    }

    @Override
    public void visitIdExpression(IdExpression expression) {

    }

    @Override
    public void visitParenthesisExpression(ParenthesisExpression expression) {

    }

    @Override
    public void visitBooleanType(BooleanType type) {

    }

    @Override
    public void visitDateType(DateType type) {

    }

    @Override
    public void visitDecimalType(DecimalType type) {

    }

    @Override
    public void visitIntegerType(IntegerType type) {

    }

    @Override
    public void visitMoneyType(MoneyType type) {

    }

    @Override
    public void visitStringType(StringType type) {

    }
}
