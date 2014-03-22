package edu.uva.softwarecons.checker.warning;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public class QuestionnaireWarning
{

    private final String message;

    public QuestionnaireWarning( String message )
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "Warning:  " + message;
    }
}
