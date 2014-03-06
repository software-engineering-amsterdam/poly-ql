package net.iplantevin.ql.evaluation;

/**
 * @author Ivan
 */
public class UndefinedVal extends Value {
    public UndefinedVal() {
    }

    public UndefinedVal getValue() {
        return new UndefinedVal();
    }

    @Override
    public boolean isUndefined() {
        return true;
    }

    @Override
    public boolean equals(Object object) {
        // Undefined isn't equal to anything.
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    // Important to override, since default implementation would lead to an
    // infinite loop!
    @Override
    public String toString() {
        return "UNDEFINED";
    }
}
