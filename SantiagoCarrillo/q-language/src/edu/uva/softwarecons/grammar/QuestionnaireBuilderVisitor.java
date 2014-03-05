package edu.uva.softwarecons.grammar;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.Expression;
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
import edu.uva.softwarecons.visitor.IFormElement;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class QuestionnaireBuilderVisitor extends QuestionnaireBaseVisitor<IFormElement> {

    @Override
    public IFormElement visitQuestionnaire(@NotNull QuestionnaireParser.QuestionnaireContext ctx) {
        List<Question> questions = new ArrayList<Question>();
        for (QuestionnaireParser.QuestionContext question : ctx.question()) {
            questions.add((Question) question.accept(this));
        }
        return new Form(ctx.ID().getText(), questions);
    }

    @Override
    public BasicQuestion visitSimpleQuestion(@NotNull QuestionnaireParser.SimpleQuestionContext ctx) {
        return new BasicQuestion(ctx.ID().getText(), ctx.STRING().getText(), (Type) ctx.type().accept(this));
    }

    @Override
    public ComputedQuestion visitComputedQuestion(@NotNull QuestionnaireParser.ComputedQuestionContext ctx) {
        return new ComputedQuestion(ctx.ID().getText(), ctx.STRING().getText(), (Type) ctx.type().accept(this), (Expression) ctx.expr().accept(this));
    }

    @Override
    public BooleanType visitBoolean(@NotNull QuestionnaireParser.BooleanContext ctx) {
        return new BooleanType(false);
    }

    @Override
    public StringType visitString(@NotNull QuestionnaireParser.StringContext ctx) {
        return new StringType(null);
    }

    @Override
    public IntegerType visitInteger(@NotNull QuestionnaireParser.IntegerContext ctx) {
        return new IntegerType(0);
    }

    @Override
    public DateType visitDate(@NotNull QuestionnaireParser.DateContext ctx) {
        return new DateType(null);
    }

    @Override
    public DecimalType visitDecimal(@NotNull QuestionnaireParser.DecimalContext ctx) {
        return new DecimalType(0);
    }

    @Override
    public MoneyType visitMoney(@NotNull QuestionnaireParser.MoneyContext ctx) {
        return new MoneyType(null);
    }


    @Override
    public IfQuestion visitIf(@NotNull QuestionnaireParser.IfContext ctx) {
        List<Question> questions = new ArrayList<Question>();
        for (QuestionnaireParser.QuestionContext q : ctx.question()) {
            questions.add((Question) q.accept(this));
        }
        ElseQuestion elseQuestion = null;
        if (null != ctx.elsestat())
            elseQuestion = (ElseQuestion) ctx.elsestat().accept(this);
        return new IfQuestion((Expression) ctx.expr().accept(this), questions, elseQuestion);
    }

    @Override
    public ElseQuestion visitElse(@NotNull QuestionnaireParser.ElseContext ctx) {
        List<Question> questions = new ArrayList<Question>();
        for (QuestionnaireParser.QuestionContext q : ctx.question()) {
            questions.add((BasicQuestion) q.accept(this));
        }
        return new ElseQuestion(questions);

    }


    @Override
    public OrExpression visitOr(@NotNull QuestionnaireParser.OrContext ctx) {
        return new OrExpression((Expression) ctx.expr().get(0).accept(this),
                (Expression) ctx.expr().get(1).accept(this));
    }


    //TODO fix bad smell !!
    @Override
    public Expression visitCompare(@NotNull QuestionnaireParser.CompareContext ctx) {
        if (null != ctx.Eq())
            return new EqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        if (null != ctx.GEq())
            return new GreaterEqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        if (null != ctx.GT())
            return new GreaterExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        if (null != ctx.LEq())
            return new LessEqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        if (null != ctx.LT())
            return new LessExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        if (null != ctx.NEq())
            return new NotEqualExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        assert false : "BUG: unknown compare argument";
        return null;
    }

    @Override
    public Expression visitMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx) {
        if (null != ctx.MUL())
            return new MulExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        if (null != ctx.DIV())
            return new DivExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        assert false : "BUG: unknown MulDiv argument";
        return null;
    }

    @Override
    public AndExpression visitAnd(@NotNull QuestionnaireParser.AndContext ctx) {
        return new AndExpression((Expression) ctx.expr().get(0).accept(this),
                (Expression) ctx.expr().get(1).accept(this));
    }

    @Override
    public IdExpression visitId(@NotNull QuestionnaireParser.IdContext ctx) {

        return new IdExpression(ctx.ID().getText());
    }

    @Override
    public IFormElement visitInt(@NotNull QuestionnaireParser.IntContext ctx) {
        return new IntExpression(Integer.parseInt(ctx.getText()));
    }

    @Override
    public NotExpression visitNot(@NotNull QuestionnaireParser.NotContext ctx) {
        return new NotExpression((Expression) ctx.expr().accept(this));
    }

    @Override
    public Expression visitAddSub(@NotNull QuestionnaireParser.AddSubContext ctx) {
        if (null != ctx.SUB())
            return new SubExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        if (null != ctx.SUB())
            return new AddExpression((Expression) ctx.expr().get(0).accept(this),
                    (Expression) ctx.expr().get(1).accept(this));
        assert false : "BUG: unknown AddSub argument";
        return null;
    }

    @Override
    public ParenthesisExpression visitParenthesis(@NotNull QuestionnaireParser.ParenthesisContext ctx) {
        return new ParenthesisExpression((Expression) ctx.expr().accept(this));
    }


}
