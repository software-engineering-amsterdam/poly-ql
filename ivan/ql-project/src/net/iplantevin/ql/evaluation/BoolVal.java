package net.iplantevin.ql.evaluation;

/**
 * @author Ivan
 */
public class BoolVal extends Value {
    private final Boolean value;

    public BoolVal(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public Value and(Value argument) {
        return argument.boolAnd(this);
    }

    @Override
    public Value or(Value argument) {
        return argument.boolOr(this);
    }

    @Override
    public Value not() {
        return new BoolVal(!value);
    }

    @Override
    public Value boolAnd(BoolVal argument) {
        return new BoolVal(value && argument.getValue());
    }

    @Override
    public Value boolOr(BoolVal argument) {
        return new BoolVal(value || argument.getValue());
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof BoolVal) {
            Boolean castedValue = ((BoolVal) object).getValue();
            return value.equals(castedValue);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
