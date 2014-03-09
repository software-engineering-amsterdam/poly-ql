package edu.uva.softwarecons.visitor.form;

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
import edu.uva.softwarecons.model.question.*;
import edu.uva.softwarecons.model.type.*;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.type.ITypeElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class FormPrettyPrintVisitor implements IFormElementVisitor, IExpressionElementVisitor, ITypeElementVisitor {


    @Override
    public void visitForm(Form form) {
        System.out.print("form " + form.getId() + "{\n");
        for(Question question: form.getQuestions()){
            question.accept(this);
        }
        System.out.print("\n}");
    }

    @Override
    public void visitQuestion(BasicQuestion question) {
        System.out.print("\t\t");
        System.out.print(question);
        System.out.print("\n");
    }


    @Override
    public void visitComputedQuestion(ComputedQuestion question) {
        System.out.print("\t\t");
        System.out.print(question);
        question.getExpression().accept(this);
        System.out.print(")\n");
    }

    @Override
    public void visitIfQuestion(IfQuestion question) {
        System.out.print("\t");
        System.out.print("if(");
        question.getExpression().accept(this);
        System.out.print("){");
        System.out.print("\n");
        for(Question q: question.getQuestions()){
            q.accept(this);
        }
        System.out.print("\t}");
        if(null != question.getElseQuestion())
            question.getElseQuestion().accept(this);

    }

    @Override
    public void visitElseQuestion(ElseQuestion question) {
//        System.out.print("\t");
        System.out.print("else{\n");
        for(Question q: question.getQuestions()){
            q.accept(this);
        }
        System.out.print("\t}\n");
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        System.out.print(type);
    }

    @Override
    public void visitDateType(DateType type) {
        System.out.print(type);
    }

    @Override
    public void visitDecimalType(DecimalType type) {
        System.out.print(type);
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        System.out.print(type);
    }

    @Override
    public void visitMoneyType(MoneyType type) {
        System.out.print(type);
    }

    @Override
    public void visitStringType(StringType type) {
        System.out.print(type);
    }

    @Override
    public void visitIntExpression(IntExpression expression) {
        System.out.print(expression);
    }

    @Override
    public void visitAddExpression(AddExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" + ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitDivExpression(DivExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" / ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitMulExpression(MulExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" * ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitSubExpression(SubExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" - ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitAndExpression(AndExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" && ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitOrExpression(OrExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" || ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitEqualExpression(EqualExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" == ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" >= ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" > ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" <= ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitLessExpression(LessExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" < ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {
        expression.getLeftExpression().accept(this);
        System.out.print(" != ");
        expression.getRightExpression().accept(this);
    }

    @Override
    public void visitNotExpression(NotExpression expression) {
        System.out.print("!");
        expression.getArgument().accept(this);
    }

    @Override
    public void visitParenthesisExpression(ParenthesisExpression expression) {
        System.out.print("(");
        expression.getArgument().accept(this);
        System.out.print(")");
    }

    @Override
    public void visitIdExpression(IdExpression expression) {
        System.out.print(expression.getId());
    }


}
