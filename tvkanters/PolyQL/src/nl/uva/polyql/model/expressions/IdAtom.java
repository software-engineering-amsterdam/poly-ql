package nl.uva.polyql.model.expressions;

public class IdAtom implements IAtom {

    private final String mId;
    
    public IdAtom(final String id) {
        mId = id;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
