package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class UndefinedReferenceError extends QuestionnaireError {

    public UndefinedReferenceError(String id) {
        super("Variable with id: '" + id + "' is undefined");
    }
}
