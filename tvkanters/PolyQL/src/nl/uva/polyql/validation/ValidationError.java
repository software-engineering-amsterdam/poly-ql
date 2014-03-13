package nl.uva.polyql.validation;

import nl.uva.polyql.ast.AstComponent;
import nl.uva.polyql.ast.LineInfo;

public abstract class ValidationError {

    private final LineInfo mLineInfo;

    public ValidationError(final AstComponent rule) {
        mLineInfo = rule.getLineInfo();
    }

    public boolean isFatal() {
        return true;
    }

    @Override
    public final String toString() {
        return "[" + (isFatal() ? "ERROR" : "WARNING") + "] " + mLineInfo + " " + getLabel();
    }

    protected abstract String getLabel();
}
