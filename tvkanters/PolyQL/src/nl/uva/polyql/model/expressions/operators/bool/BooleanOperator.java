package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.exceptions.UnsupportedOperandTypeException;
import nl.uva.polyql.model.expressions.operators.SameOperandOperator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;

public abstract class BooleanOperator extends SameOperandOperator<BooleanValue> {

    @Override
    public BooleanValue performOperation(final Type operandType, final Value<?> leftValue, final Value<?> rightValue) {
        return leftValue.performOperationOnLeft(this, rightValue);
    }

    /**
     * Performs the operation on boolean arguments. Invalid by default but can be overridden to
     * supply an functionality for this operand type.
     * 
     * @param left
     *            The left hand value
     * @param right
     *            The right hand value
     * 
     * @return The value resulting of applying the operation on the arguments
     */
    public BooleanValue performOperation(final BooleanValue left, final BooleanValue right) {
        throw new UnsupportedOperandTypeException(Type.BOOLEAN, getSyntax());
    }

    /**
     * Performs the operation on number arguments. Invalid by default but can be overridden to
     * supply an functionality for this operand type.
     * 
     * @param left
     *            The left hand value
     * @param right
     *            The right hand value
     * 
     * @return The value resulting of applying the operation on the arguments
     */
    public BooleanValue performOperation(final NumberValue left, final NumberValue right) {
        throw new UnsupportedOperandTypeException(Type.NUMBER, getSyntax());
    }

    /**
     * Performs the operation on string arguments. Invalid by default but can be overridden to
     * supply an functionality for this operand type.
     * 
     * @param left
     *            The left hand value
     * @param right
     *            The right hand value
     * 
     * @return The value resulting of applying the operation on the arguments
     */
    public BooleanValue performOperation(final StringValue left, final StringValue right) {
        throw new UnsupportedOperandTypeException(Type.STRING, getSyntax());
    }

    @Override
    public boolean isValid(final Type type) {
        switch (type) {
        case BOOLEAN:
        case NUMBER:
        case STRING:
            return isValidForImplementedType(type);
        default:
            return false;
        }
    }

    /**
     * Should be implemented to that it returns true for and only for the operand types that have
     * functionality implemented.
     * 
     * @param type
     *            The operand type to check for
     * 
     * @return True iff the operator is valid for the given type
     */
    public abstract boolean isValidForImplementedType(final Type type);
}
