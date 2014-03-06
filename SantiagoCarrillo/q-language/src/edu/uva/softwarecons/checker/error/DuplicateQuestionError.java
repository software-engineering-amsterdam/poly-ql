package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class DuplicateQuestionError extends QuestionnaireError{


    public DuplicateQuestionError(String id) {
        super("The question with ID: '"+id+"' is duplicated");
    }
}
