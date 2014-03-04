package edu.uva.softwarecons.checker.error;

import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/3/14
 */
public class InvalidTypeError extends QuestionnaireError{

    public InvalidTypeError(String id, Class expectedType, Class definedType) {
        super("Expected type: "+expectedType.getSimpleName()+" but got "+
                definedType.getSimpleName()+
                " for expression: "+id);
    }

    public InvalidTypeError(String questionId, String expressionId, Class expectedType, Class definedType) {
        super("Expected type: "+expectedType.getSimpleName()+" but got "+
                definedType.getSimpleName()+
                " for question: "+questionId+" and expression: "+expressionId);
    }
}
