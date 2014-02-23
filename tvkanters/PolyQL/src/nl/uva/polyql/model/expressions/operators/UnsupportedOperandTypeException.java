package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.Types;

public class UnsupportedOperandTypeException extends UnsupportedOperationException {

    private static final long serialVersionUID = 8634412238170543338L;

    public UnsupportedOperandTypeException(final Types type) {
        super("Operand type " + type + " unsupported for this operator");
    }

}
