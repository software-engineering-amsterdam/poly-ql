package edu.uva.softwarecons.evaluator;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.ElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.value.BooleanValue;
import edu.uva.softwarecons.ui.question.QuestionHBox;
import edu.uva.softwarecons.visitor.form.FormElementVisitor;

import java.util.HashMap;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/16/14
 */
public class QuestionEvalVisitor
    implements FormElementVisitor
{

    private boolean displayQuestion;

    private HashMap<String, QuestionHBox> questions = new HashMap<String, QuestionHBox>();

    private final ExpressionEvaluator expressionEvaluator;

    public QuestionEvalVisitor( boolean displayQuestion, HashMap<String, QuestionHBox> questions,
                                ExpressionEvaluator expressionEvaluator )
    {
        this.displayQuestion = displayQuestion;
        this.questions = questions;
        this.expressionEvaluator = expressionEvaluator;
    }

    @Override
    public void visitForm( Form form )
    {
    }

    @Override
    public void visitComputedQuestion( ComputedQuestion question )
    {
        questions.get( question.getId() ).setVisible( displayQuestion );
        questions.get( question.getId() ).
            updateValue( question.getExpression().accept( expressionEvaluator ) );
    }

    @Override
    public void visitQuestion( BasicQuestion question )
    {
        questions.get( question.getId() ).setVisible( displayQuestion );
    }

    @Override
    public void visitIfQuestion( IfQuestion question )
    {
        boolean display = ( (BooleanValue) question.getExpression().accept( expressionEvaluator ) ).getValue();
        for ( Question q : question.getQuestions() )
        {
            q.accept( new QuestionEvalVisitor( displayQuestion && display, questions, expressionEvaluator ) );
        }
        if ( null != question.getElseQuestion() )
        {
            question.getElseQuestion().accept(
                new QuestionEvalVisitor( !( displayQuestion && display ), questions, expressionEvaluator ) );
        }
    }

    @Override
    public void visitElseQuestion( ElseQuestion question )
    {
        for ( Question q : question.getQuestions() )
        {
            q.accept( this );
        }

    }
}
