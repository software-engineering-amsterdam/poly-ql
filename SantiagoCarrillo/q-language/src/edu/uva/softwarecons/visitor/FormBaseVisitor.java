package edu.uva.softwarecons.visitor;

import edu.uva.softwarecons.model.Form;
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
 * Date: 2/27/14
 */
public class FormBaseVisitor implements IFormElementVisitor {


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
    public void visitIdExpression(IdExpression expression) {

    }

    @Override
    public void visitIntExpression(IntExpression expression) {

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

    @Override
    public void visitAddExpression(AddExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitDivExpression(DivExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitMulExpression(MulExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitSubExpression(SubExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitAndExpression(AndExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitOrExpression(OrExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitEqualExpression(EqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitLessExpression(LessExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitNotExpression(NotExpression expression) {
        expression.expression.accept(this);
    }

    @Override
    public void visitParenthesisExpression(ParenthesisExpression expression) {
        expression.expression.accept(this);
    }


}
