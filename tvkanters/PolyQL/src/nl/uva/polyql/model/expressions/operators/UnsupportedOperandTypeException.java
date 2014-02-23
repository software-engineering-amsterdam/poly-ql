package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.Expression;

public class UnsupportedOperandTypeException extends UnsupportedOperationException {

    private static final long serialVersionUID = 8634412238170543338L;

    public UnsupportedOperandTypeException(final Types left, final String operatorSyntax, final Types right) {
        super("Operand types " + left + "-" + right + " unsupported for operator " + operatorSyntax);
    }

    public UnsupportedOperandTypeException(final Expression left, final String operatorSyntax, final Expression right) {
        this(left.getReturnType(), operatorSyntax, right.getReturnType());
    }

    public UnsupportedOperandTypeException(final Types typeLeftRight, final String operatorSyntax) {
        this(typeLeftRight, operatorSyntax, typeLeftRight);
    }

}
