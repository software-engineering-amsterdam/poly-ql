package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.visitor.form.FormElementVisitor;

import java.util.List;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/26/14
 */
public class IfQuestion
    implements Question
{

    private final Expression expression;

    private final List<Question> questions;

    private final ElseQuestion elseQuestion;

    private final String condition;

    public IfQuestion( Expression expression, List<Question> questions, ElseQuestion elseQuestion, String condition )
    {
        this.expression = expression;
        this.questions = questions;
        this.elseQuestion = elseQuestion;
        this.condition = condition;
    }

    public Expression getExpression()
    {
        return expression;
    }

    public List<Question> getQuestions()
    {
        return questions;
    }

    public ElseQuestion getElseQuestion()
    {
        return elseQuestion;
    }

    @Override
    public void accept( FormElementVisitor visitor )
    {
        visitor.visitIfQuestion( this );
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof IfQuestion;
    }

    public String getConditionText()
    {
        return condition;
    }
}
