package net.iplantevin.ql.evaluation;

/**
 * @author Ivan
 */
public class StrVal extends Value {
    private final String value;

    public StrVal(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof StrVal) {
            String castedString = ((StrVal) object).getValue();
            return value.equals(castedString);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
