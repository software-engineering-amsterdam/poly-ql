package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public class ConditionInvalidTypeError
    extends QuestionnaireError
{

    public ConditionInvalidTypeError( String id )
    {
        super( "The argument with ID: '" + id + "' is not a Boolean Type" );
    }
}
