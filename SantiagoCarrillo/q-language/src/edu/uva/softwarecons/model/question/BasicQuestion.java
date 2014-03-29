package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.form.FormElementVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/19/14
 */
public class BasicQuestion
    implements Question
{

    protected final String id;

    protected final String text;

    protected final Type type;


    public BasicQuestion( String id, String text, Type type )
    {
        this.id = id;
        this.text = text;
        this.type = type;
    }

    @Override
    public void accept( FormElementVisitor visitor )
    {
        visitor.visitQuestion( this );
    }

    @Override
    public String toString()
    {
        return "" + id + ": " + text + " " + ( null != type ? type.toString() : "" );
    }

    public String getId()
    {
        return id;
    }

    public Type getType()
    {
        return type;
    }

    public String getText()
    {
        return text;
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof BasicQuestion;
    }
}
