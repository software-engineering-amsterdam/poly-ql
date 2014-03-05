package net.iplantevin.ql.evaluation;

/**
 * Declares default implementations for double dispatch on Value subtypes. All
 * operations must return Value objects, if an operation is not valid, return
 * the Undefined type (default for all operations except equal and notEqual).
 *
 * @author Ivan
 */
public abstract class Value {
    // Equality operations, the only ones that work between all Value subtypes.
    public BoolVal equal(Value argument) {
        return new BoolVal(this.equals(argument));
    }

    public BoolVal notEqual(Value argument) {
        return new BoolVal(this.equals(argument));
    }

    public abstract Object getValue();
}
