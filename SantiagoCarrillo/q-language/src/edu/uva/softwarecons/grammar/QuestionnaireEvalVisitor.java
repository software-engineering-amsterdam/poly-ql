package edu.uva.softwarecons.grammar;

import edu.uva.softwarecons.model.*;
import edu.uva.softwarecons.model.expression.Expression;
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
import edu.uva.softwarecons.visitor.IFormElement;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class QuestionnaireEvalVisitor extends QuestionnaireBaseVisitor<IFormElement>{

    @Override
    public IFormElement visitQuestionnaire(@NotNull QuestionnaireParser.QuestionnaireContext ctx) {
        Form form = new Form(ctx.ID().getText());
        for(QuestionnaireParser.QuestionContext question: ctx.question()){
            form.addQuestion((Question) question.accept(this));
        }
        return form;
    }

    @Override
    public Question visitSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx) {
        return new Question(ctx.ID().getText(),ctx.STRING().getText(), (Type) ctx.type().accept(this));
    }

    @Override
    public ComputedQuestion visitComputedQuestion(@NotNull QuestionnaireParser.ComputedQuestionContext ctx) {
        return new ComputedQuestion(ctx.ID().getText(),ctx.STRING().getText(), (Type) ctx.type().accept(this), (Expression) ctx.expr().accept(this));
    }

    @Override
    public BooleanType visitBoolean(@NotNull QuestionnaireParser.BooleanContext ctx) {
        return new BooleanType();
    }

    @Override
    public StringType visitString(@NotNull QuestionnaireParser.StringContext ctx) {
        return new StringType();
    }

    @Override
    public IntegerType visitInteger(@NotNull QuestionnaireParser.IntegerContext ctx) {
        return new IntegerType();
    }

    @Override
    public DateType visitDate(@NotNull QuestionnaireParser.DateContext ctx) {
        return new DateType();
    }

    @Override
    public DecimalType visitDecimal(@NotNull QuestionnaireParser.DecimalContext ctx) {
        return new DecimalType();
    }

    @Override
    public MoneyType visitMoney(@NotNull QuestionnaireParser.MoneyContext ctx) {
        return new MoneyType();
    }

    @Override
    public IfQuestion visitIf(@NotNull QuestionnaireParser.IfContext ctx) {
        IfQuestion question = null == ctx.elsestat() ? new IfQuestion() : (IfElseQuestion) ctx.elsestat().accept(this);
        question.expression = (Expression) ctx.expr().accept(this);
        for(QuestionnaireParser.QuestionContext q : ctx.question()){
            question.addQuestion((Question) q.accept(this));
        }
        return question;
    }

    @Override
    public IfElseQuestion visitIfElse(@NotNull QuestionnaireParser.IfElseContext ctx) {
        IfElseQuestion ifElseQuestion = new IfElseQuestion();
        for(QuestionnaireParser.QuestionContext q : ctx.question()){
            ifElseQuestion.addElseQuestion((Question) q.accept(this));
        }
        return ifElseQuestion;
    }



    @Override
    public OrExpression visitOr(@NotNull QuestionnaireParser.OrContext ctx) {
        return new OrExpression((Expression) ctx.expr().get(0).accept(this),
                (Expression) ctx.expr().get(1).accept(this));
    }

    @Override
    public Type visitTypeExp(@NotNull QuestionnaireParser.TypeExpContext ctx) {
        return (Type) ctx.type().accept(this);
    }


    //TODO fix bad smell !!
    @Override
    public Expression visitCompare(@NotNull QuestionnaireParser.CompareContext ctx) {
        if(null != ctx.Eq())
            return new EqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        else if(null != ctx.GEq())
            return new GreaterEqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        else if(null != ctx.GT())
            return new GreaterExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        else if(null != ctx.LEq())
            return new LessEqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        else if(null != ctx.LT())
            return new LessExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        else if(null != ctx.NEq())
            return new NotEqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        return null;

    }

    @Override
    public Expression visitMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx) {
        return (null != ctx.MUL()) ?
                new MulExpression((Expression) ctx.expr().get(0).accept(this),
                        (Expression) ctx.expr().get(1).accept(this)):
                new DivExpression((Expression) ctx.expr().get(0).accept(this),
                        (Expression) ctx.expr().get(1).accept(this));
    }

    @Override
    public AndExpression visitAnd(@NotNull QuestionnaireParser.AndContext ctx) {
        return  new AndExpression((Expression) ctx.expr().get(0).accept(this),
                (Expression) ctx.expr().get(1).accept(this));
    }

    @Override
    public IdExpression visitId(@NotNull QuestionnaireParser.IdContext ctx) {
        return new IdExpression(ctx.ID().getText());
    }

    @Override
    public NotExpression visitNot(@NotNull QuestionnaireParser.NotContext ctx) {
        return new NotExpression((Expression) ctx.expr().accept(this));
    }

    @Override
    public Expression visitAddSub(@NotNull QuestionnaireParser.AddSubContext ctx) {
        return (null != ctx.SUB()) ?
                new SubExpression((Expression) ctx.expr().get(0).accept(this),
                        (Expression) ctx.expr().get(1).accept(this)):
                new AddExpression((Expression) ctx.expr().get(0).accept(this),
                        (Expression) ctx.expr().get(1).accept(this));
    }

    @Override
    public ParenthesisExpression visitParenthesis(@NotNull QuestionnaireParser.ParenthesisContext ctx) {
        return new ParenthesisExpression((Expression) ctx.expr().accept(this));
    }


}
