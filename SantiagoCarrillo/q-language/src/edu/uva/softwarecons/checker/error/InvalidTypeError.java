package edu.uva.softwarecons.checker.error;

import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/3/14
 */
public class InvalidTypeError
    extends QuestionnaireError
{

    public InvalidTypeError( String id, String expectedType, String definedType )
    {
        super( "Expected type: " + expectedType + " but got " +
                   definedType +
                   " for argument: '" + id + "'" );
    }

    public InvalidTypeError( String questionId, String expressionId, String expectedType, String definedType )
    {
        super( "Expected type: " + expectedType + " but got " +
                   definedType +
                   " for question: " + questionId + " and argument: '" + expressionId + "'" );
    }

    public InvalidTypeError( String operand, Type type )
    {
        super( "InvalidType: " + type + " for operand: " + operand );
    }

    public InvalidTypeError( String questionId, String type )
    {
        super( "InvalidType: " + type + " for question: " + questionId );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof InvalidTypeError;
    }
}
