package edu.uva.softwarecons.checker.warning;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public class DuplicatedQuestionLabelWarning
    extends QuestionnaireWarning
{

    public DuplicatedQuestionLabelWarning( String questionId1, String questionId2 )
    {
        super( "The questions with IDs: '" + questionId1 + "' and '" + questionId2 + "' have a duplicated label" );
    }
}
