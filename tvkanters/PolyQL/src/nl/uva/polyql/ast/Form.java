package nl.uva.polyql.ast;

public class Form extends RuleContainer {

    private final String mLabel;

    public Form(final String label) {
        mLabel = label;
    }

    public String getLabel() {
        return mLabel;
    }

    @Override
    public String toString() {
        return "FORM " + mLabel;
    }

}
