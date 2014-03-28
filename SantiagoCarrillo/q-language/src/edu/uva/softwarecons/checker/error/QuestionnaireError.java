package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public class QuestionnaireError
{

    private final String message;

    public QuestionnaireError( String message )
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "Error: " + message;
    }
}
