package edu.uva.softwarecons.model;

import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.visitor.form.FormElement;
import edu.uva.softwarecons.visitor.form.FormElementVisitor;

import java.util.List;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/25/14
 */
public class Form
    implements FormElement
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
    public void accept( FormElementVisitor visitor )
    {
        visitor.visitForm( this );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof Form;
    }
}
