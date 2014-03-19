package main.nl.uva.validation.error;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Variable;

public class DuplicatedVariableError extends ValidationError {

    public DuplicatedVariableError(final Variable original, final Line lineInfoDuplicate) {
        super(lineInfoDuplicate + " Variable \"" + original.getName() + "\" already declared at " + original.getLineInfo());
    }

}
