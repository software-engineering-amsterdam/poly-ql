package edu.uva.softwarecons.checker.error;

/**
 * @author: Santiago Carrillo
 * Date: 3/20/14
 */
public class InvalidComputedQuestionType
    extends QuestionnaireError
{
    public InvalidComputedQuestionType( String questionID )
    {
        super( "The question with ID '" + questionID + "' has an invalid type. It must be a numeric type" );
    }
}
