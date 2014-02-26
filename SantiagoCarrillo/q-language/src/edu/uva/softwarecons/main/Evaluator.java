package edu.uva.softwarecons.main;

import edu.uva.softwarecons.grammar.QuestionnaireBaseListener;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
import edu.uva.softwarecons.model.ConditionalQuestion;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.Question;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.VariableExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.bool.AndExpression;
import edu.uva.softwarecons.model.expression.bool.NotExpression;
import edu.uva.softwarecons.model.expression.bool.OrExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.type.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class Evaluator extends QuestionnaireBaseListener{


    Form form;

    Question currentQuestion;

    Type currentType;

    boolean isSimpleQuestion = true;

    boolean isBinaryExpression;

    Expression currentExpression;

    Expression currentLeftExpression;

    Expression currentRightExpression;


    @Override
    public void enterQuestionnaire(@NotNull QuestionnaireParser.QuestionnaireContext ctx) {
        super.enterQuestionnaire(ctx);
        form = new Form(ctx.ID().getText());
    }

    @Override
    public void enterIf(@NotNull QuestionnaireParser.IfContext ctx) {
        super.enterIf(ctx);
        isSimpleQuestion = false;
    }

    @Override
    public void exitIf(@NotNull QuestionnaireParser.IfContext ctx) {
        super.exitIf(ctx);
        isSimpleQuestion = true;
    }

    @Override
    public void enterSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx) {
        super.enterSimpleQuestion(ctx);
        currentQuestion = isSimpleQuestion ? new Question(ctx.ID().getText(), ctx.STRING().getText()):
                new ConditionalQuestion(ctx.ID().getText(), ctx.STRING().getText());
    }

    @Override
    public void exitSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx) {
        super.exitSimpleQuestion(ctx);
        currentQuestion.setType(currentType);
        if(currentQuestion instanceof ConditionalQuestion){
            ((ConditionalQuestion)currentQuestion).setExpression(currentExpression);
            form.addConditionalQuestion((ConditionalQuestion) currentQuestion);
        }else
            form.addQuestion(currentQuestion);
    }

    //Data Types

    @Override
    public void exitBool(@NotNull QuestionnaireParser.BoolContext ctx) {
        super.exitBool(ctx);
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
    }

    @Override
    public void exitNot(@NotNull QuestionnaireParser.NotContext ctx) {
        super.exitNot(ctx);
        currentExpression = new NotExpression();
    }

    @Override
    public void exitVariable(@NotNull QuestionnaireParser.VariableContext ctx) {
        super.exitVariable(ctx);
        if(isBinaryExpression){
            if(null == currentLeftExpression)
                currentLeftExpression = new VariableExpression(ctx.ID().getText());
            else
                currentRightExpression = new VariableExpression(ctx.ID().getText());
        }
    }
}
