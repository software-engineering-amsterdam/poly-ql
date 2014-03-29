package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.visitor.form.FormElementVisitor;

import java.util.List;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/5/14
 */
public class ElseQuestion
    implements Question
{

    private final List<Question> questions;

    public ElseQuestion( List<Question> questions )
    {
        this.questions = questions;
    }

    public List<Question> getQuestions()
    {
        return questions;
    }

    @Override
    public void accept( FormElementVisitor visitor )
    {
        visitor.visitElseQuestion( this );
    }


}
