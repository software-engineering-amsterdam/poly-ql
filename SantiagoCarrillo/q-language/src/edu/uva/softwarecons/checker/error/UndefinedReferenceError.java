package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public class UndefinedReferenceError
    extends QuestionnaireError
{

    public UndefinedReferenceError( String id )
    {
        super( "Variable with id: '" + id + "' is undefined" );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof UndefinedReferenceError;
    }
}
