package edu.uva.softwarecons.main;

import edu.uva.softwarecons.grammar.QuestionnaireBaseListener;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.bool.AndExpression;
import edu.uva.softwarecons.model.expression.bool.OrExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.type.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class QuestionnaireEvaluator extends QuestionnaireBaseListener{


    Form form;

    Type currentType;

    IfQuestion currentIfQuestion;

    boolean isIfQuestion = false;

    boolean isIfQuestionExpressionSet = false;

    boolean isBinaryExpression;

    Expression currentExpression;

    Expression currentLeftExpression;

    Expression currentRightExpression;


    @Override
    public void enterQuestionnaire(@NotNull QuestionnaireParser.QuestionnaireContext ctx) {
        super.enterQuestionnaire(ctx);
        form = new Form(ctx.ID().getText());
    }

    private void checkForIfQuestionExpression() {
        if(isIfQuestion && !isIfQuestionExpressionSet){
            currentIfQuestion.setExpression(currentExpression);
            isIfQuestionExpressionSet = true;
        }
    }

    @Override
    public void enterIf(@NotNull QuestionnaireParser.IfContext ctx) {
        super.enterIf(ctx);
        isIfQuestion = true;
        currentIfQuestion = new IfQuestion();
    }

    @Override
    public void exitIf(@NotNull QuestionnaireParser.IfContext ctx) {
        super.exitIf(ctx);
        form.addQuestion(currentIfQuestion);
        isIfQuestion = false;
    }


    //Simple Question

    @Override
    public void exitSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx) {
        super.exitSimpleQuestion(ctx);
        if(isIfQuestion){
            currentIfQuestion.addQuestion(new Question(ctx.ID().getText(), ctx.STRING().getText(), currentType));
        }else
            form.addQuestion(new Question(ctx.ID().getText(), ctx.STRING().getText(), currentType));
    }

    //Computed Question

    @Override
    public void exitComputedQuestion(@NotNull QuestionnaireParser.ComputedQuestionContext ctx) {
        super.exitComputedQuestion(ctx);
        if(isIfQuestion)
            currentIfQuestion.addQuestion(new ComputedQuestion(ctx.ID().getText(), ctx.STRING().getText(), currentType, currentExpression));
        else
            form.addQuestion(new ComputedQuestion(ctx.ID().getText(), ctx.STRING().getText(), currentType, currentExpression));
    }


    //Data Types

    @Override
    public void exitBoolean(@NotNull QuestionnaireParser.BooleanContext ctx) {
        super.exitBoolean(ctx);
        currentType = new BooleanType();
    }

    @Override
    public void exitDate(@NotNull QuestionnaireParser.DateContext ctx) {
        super.exitDate(ctx);
        currentType = new DateType();
    }

    @Override
    public void exitDecimal(@NotNull QuestionnaireParser.DecimalContext ctx) {
        super.exitDecimal(ctx);
        currentType = new DecimalType();
    }

    @Override
    public void exitInteger(@NotNull QuestionnaireParser.IntegerContext ctx) {
        super.exitInteger(ctx);
        currentType = new IntegerType();
    }

    @Override
    public void exitMoney(@NotNull QuestionnaireParser.MoneyContext ctx) {
        super.exitMoney(ctx);
        currentType = new MoneyType();
    }

    @Override
    public void exitString(@NotNull QuestionnaireParser.StringContext ctx) {
        super.exitString(ctx);
        currentType = new StringType();
    }

    //Binary Expressions

    private void startBinaryExpression() {
        isBinaryExpression = true;
        currentLeftExpression = null;
        currentRightExpression = null;
    }

    @Override
    public void enterMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx) {
        super.enterMulDiv(ctx);
        startBinaryExpression();
    }

    @Override
    public void exitMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx) {
        super.exitMulDiv(ctx);
        isBinaryExpression = false;
        currentExpression = (null != ctx.MUL()) ?
                new MulExpression(currentLeftExpression, currentRightExpression):
                new DivExpression(currentLeftExpression, currentRightExpression);
        checkForIfQuestionExpression();

    }

    @Override
    public void enterAddSub(@NotNull QuestionnaireParser.AddSubContext ctx) {
        super.enterAddSub(ctx);
        startBinaryExpression();
    }


    @Override
    public void exitAddSub(@NotNull QuestionnaireParser.AddSubContext ctx) {
        super.exitAddSub(ctx);
        currentExpression = (null != ctx.SUB()) ?
                new SubExpression(currentLeftExpression, currentRightExpression):
                new AddExpression(currentLeftExpression, currentRightExpression);
        isBinaryExpression = false;
        checkForIfQuestionExpression();
    }

    @Override
    public void enterAnd(@NotNull QuestionnaireParser.AndContext ctx) {
        super.enterAnd(ctx);
        startBinaryExpression();
    }

    @Override
    public void exitAnd(@NotNull QuestionnaireParser.AndContext ctx) {
        super.exitAnd(ctx);
        currentExpression = new AndExpression(currentLeftExpression, currentRightExpression);
        isBinaryExpression = false;
        checkForIfQuestionExpression();

    }

    @Override
    public void enterOr(@NotNull QuestionnaireParser.OrContext ctx) {
        super.enterOr(ctx);
        startBinaryExpression();
    }

    @Override
    public void exitOr(@NotNull QuestionnaireParser.OrContext ctx) {
        super.exitOr(ctx);
        currentExpression = new OrExpression(currentLeftExpression, currentRightExpression);
        isBinaryExpression = false;
        checkForIfQuestionExpression();

    }

    @Override
    public void enterCompare(@NotNull QuestionnaireParser.CompareContext ctx) {
        super.enterCompare(ctx);
        startBinaryExpression();
        isBinaryExpression = true;
    }

    @Override
    public void exitCompare(@NotNull QuestionnaireParser.CompareContext ctx) {
        super.exitCompare(ctx);
        if(null != ctx.Eq())
            currentExpression = new EqualExpression(currentLeftExpression, currentRightExpression);
        else if(null != ctx.GEq())
            currentExpression = new GreaterEqualExpression(currentLeftExpression, currentRightExpression);
        else if(null != ctx.GT())
            currentExpression = new GreaterExpression(currentLeftExpression, currentRightExpression);
        else if(null != ctx.LEq())
            currentExpression = new LessEqualExpression(currentLeftExpression, currentRightExpression);
        else if(null != ctx.LT())
            currentExpression = new LessExpression(currentLeftExpression, currentRightExpression);
        else if(null != ctx.NEq())
            currentExpression = new NotEqualExpression(currentLeftExpression, currentRightExpression);
        checkForIfQuestionExpression();
    }



    @Override
    public void exitNot(@NotNull QuestionnaireParser.NotContext ctx) {
        super.exitNot(ctx);
//        currentExpression = new NotExpression();
        checkForIfQuestionExpression();
    }

    @Override
    public void exitId(@NotNull QuestionnaireParser.IdContext ctx) {
        super.exitId(ctx);
        if(isBinaryExpression){
            if(null == currentLeftExpression)
                currentLeftExpression = new IdExpression(ctx.ID().getText());
            else
                currentRightExpression = new IdExpression(ctx.ID().getText());
        }else
            currentExpression = new IdExpression(ctx.ID().getText());
        checkForIfQuestionExpression();
    }
}
