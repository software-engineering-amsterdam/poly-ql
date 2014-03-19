package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public class DuplicateQuestionError
    extends QuestionnaireError
{


    public DuplicateQuestionError( String id )
    {
        super( "The question with ID: '" + id + "' is duplicated" );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof DuplicateQuestionError;
    }
}
