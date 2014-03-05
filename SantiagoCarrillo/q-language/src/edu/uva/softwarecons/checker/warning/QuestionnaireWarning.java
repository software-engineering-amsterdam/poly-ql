package edu.uva.softwarecons.checker.warning;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class QuestionnaireWarning {

    private String message;

    public QuestionnaireWarning(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
