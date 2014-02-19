package nl.uva.polyql.model.expressions;

public class NumberAtom implements IAtom {

    private final double mValue;

    public NumberAtom(final double value) {
        mValue = value;
    }
    public NumberAtom(final String value) {
        mValue = Double.parseDouble(value);
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public double getValue() {
        return mValue;
    }
}
