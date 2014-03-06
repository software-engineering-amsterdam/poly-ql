package edu.uva.softwarecons.checker.warning;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class DuplicatedQuestionLabelWarning extends  QuestionnaireWarning{

    public DuplicatedQuestionLabelWarning(String questionId1, String questionId2) {
        super("The questions with ID: "+questionId1+" and "+questionId2+" have a duplicated label");
    }
}
