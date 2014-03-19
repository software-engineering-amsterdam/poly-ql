package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/3/14
 */
public class CyclicDependencyError
    extends QuestionnaireError
{

    public CyclicDependencyError( String questionID )
    {
        super( "The question with ID: '" + questionID + "' has a cyclic dependency" );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof CyclicDependencyError;
    }
}
