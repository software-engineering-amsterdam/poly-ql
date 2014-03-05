package net.iplantevin.ql.evaluation;

/**
 * @author Ivan
 */
public class IntVal extends Value {
    private final Integer value;

    public IntVal(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof IntVal) {
            Integer castedInt = ((IntVal) object).getValue();
            return value.equals(castedInt);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
