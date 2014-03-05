package edu.uva.softwarecons.visitor;

import edu.uva.softwarecons.model.Form;
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
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.ElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
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
    public void visitIfQuestion(IfQuestion question) {

    }

    @Override
    public void visitElseQuestion(ElseQuestion question) {

    }

    @Override
    public void visitQuestion(BasicQuestion question) {

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
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitDivExpression(DivExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitMulExpression(MulExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitSubExpression(SubExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitAndExpression(AndExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitOrExpression(OrExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitEqualExpression(EqualExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitLessExpression(LessExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {
        expression.getLeftExpression().accept(this);
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitNotExpression(NotExpression expression) {
        expression.getArgument().accept(this);
    }

    @Override
    public void visitParenthesisExpression(ParenthesisExpression expression) {
        expression.getArgument().accept(this);
    }


}
