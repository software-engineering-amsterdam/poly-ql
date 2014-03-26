package edu.uva.softwarecons.checker.error;

/**
 * @author: Santiago Carrillo
 * Date: 3/20/14
 */
public class InvalidComputedQuestionExpressionType
    extends QuestionnaireError
{
    public InvalidComputedQuestionExpressionType( String questionID )
    {
        super( "The expression of the question with ID '" + questionID
                   + "' has an invalid type. It must be a numeric type" );
    }
}
