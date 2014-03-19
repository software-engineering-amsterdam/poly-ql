package main.nl.uva.parser.element.error;

import main.nl.uva.parser.element.Line;
import main.nl.uva.parser.element.expression.Variable;

public class DuplicatedVariableError extends ValidationError {

    public DuplicatedVariableError(final Variable original, final Line lineInfoDuplicate) {
        super(lineInfoDuplicate + " Variable \"" + original.getName() + "\" already declared at " + original.getLineInfo());
    }

}
