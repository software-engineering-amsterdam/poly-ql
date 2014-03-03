package edu.uva.softwarecons.checker.error;

import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/3/14
 */
public class InvalidTypeError extends QuestionnaireError{

    public InvalidTypeError(String id, Type expectedType, Type definedType) {
        super("Expected type: "+expectedType.getClass().getSimpleName()+" but got "+
                definedType.getClass().getSimpleName()+
                " for expression: "+id);
    }
}
