package edu.uva.softwarecons.model;

import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.visitor.form.IFormElement;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

import java.util.List;

/**
 * Falconlabs
 * @author Santiago Carrillo
 * Date: 2/25/14
 */
public class Form
    implements IFormElement
{

    private final String id;

    private final List<Question> questions;

    public Form( String id, List<Question> questions )
    {
        this.id = id;
        this.questions = questions;
    }

    public String getId()
    {
        return id;
    }

    public List<Question> getQuestions()
    {
        return questions;
    }

    @Override
    public void accept( IFormElementVisitor visitor )
    {
        visitor.visitForm( this );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof Form;
    }
}
