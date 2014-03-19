package main.nl.uva.validation.warning;

import main.nl.uva.parser.Line;

public class DuplicateLabelWarning extends ValidationWarning {

    public DuplicateLabelWarning(final String label, final Line original, final Line duplicate) {
        super("Label \"" + label + "\" defined at " + original + " reused at " + duplicate);
    }
}
