package edu.uva.softwarecons.checker.error;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class QuestionnaireError{

    private String message;

    public QuestionnaireError(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error: "+message;
    }
}
