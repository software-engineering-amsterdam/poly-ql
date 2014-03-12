package net.iplantevin.ql.evaluation;

/**
 * Declares default implementations for double dispatch on Value subtypes. All
 * operations must return Value objects, if an operation is not valid, return
 * the Undefined type (default for all operations except equal and notEqual).
 *
 * @author Ivan
 */
public abstract class Value {
    private static final UndefinedVal UNDEFINED = new UndefinedVal();

    // Every Value subtype must return a value (e.g. Integer, UndefinedVal, ...)
    // so the return type of the abstract method is Object.
    public abstract Object getValue();

    /**
     * Since |equals| cannot be used with UndefinedVal, another way is necessary
     * to know whether you've got an UndefinedVal.
     *
     * @return whether this Value is an UndefinedVal.
     */
    public boolean isUndefined() {
        return false;
    }

    // Equality operations, the only ones that work between all Value subtypes.
    public BoolVal equal(Value argument) {
        return new BoolVal(this.equals(argument));
    }

    public BoolVal notEqual(Value argument) {
        return new BoolVal(this.equals(argument));
    }

    // The other operations return default UndefinedVal (from field).
    public Value add(Value argument) {
        return UNDEFINED;
    }

    public Value sub(Value argument) {
        return UNDEFINED;
    }

    public Value mul(Value argument) {
        return UNDEFINED;
    }

    public Value div(Value argument) {
        return UNDEFINED;
    }

    public Value and(Value argument) {
        return UNDEFINED;
    }

    public Value or(Value argument) {
        return UNDEFINED;
    }

    public Value not() {
        return UNDEFINED;
    }

    public Value geq(Value argument) {
        return UNDEFINED;
    }

    public Value gt(Value argument) {
        return UNDEFINED;
    }

    public Value leq(Value argument) {
        return UNDEFINED;
    }

    public Value lt(Value argument) {
        return UNDEFINED;
    }

    public Value neg() {
        return UNDEFINED;
    }

    public Value pos() {
        return UNDEFINED;
    }

    // Methods for double dispatch. For each of the above operations, given a
    // specific Value type, if the operation will be used, a corresponding double
    // dispatch method must be defined.
    // Note: crucial is the specific Value types used as arguments instead of
    // generic Value type! (And double dispatch not needed for unary operators)
    // Note: protected, since should only be relevant and visible to Value objects.
    protected Value boolAnd(BoolVal argument) {
        return UNDEFINED;
    }

    protected Value boolOr(BoolVal argument) {
        return UNDEFINED;
    }

    protected Value intAdd(IntVal argument) {
        return UNDEFINED;
    }

    protected Value intSub(IntVal argument) {
        return UNDEFINED;
    }

    protected Value intMul(IntVal argument) {
        return UNDEFINED;
    }

    protected Value intDiv(IntVal argument) {
        return UNDEFINED;
    }

    protected Value intGeq(IntVal argument) {
        return UNDEFINED;
    }

    protected Value intGt(IntVal argument) {
        return UNDEFINED;
    }

    protected Value intLeq(IntVal argument) {
        return UNDEFINED;
    }

    protected Value intLt(IntVal argument) {
        return UNDEFINED;
    }

    // Default toString relies on toString of internal value of a Value object.
    @Override
    public String toString() {
        return getValue().toString();
    }
}
