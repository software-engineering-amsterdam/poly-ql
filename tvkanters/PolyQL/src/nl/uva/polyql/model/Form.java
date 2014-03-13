package nl.uva.polyql.model;

import java.util.LinkedList;
import java.util.List;

public class Form extends RuleContainer {

    private final String mLabel;
    private final List<String> mWarnings = new LinkedList<>();

    public Form(final String label) {
        mLabel = label;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    public List<String> getWarnings() {
        return mWarnings;
    }

    @Override
    public String toString() {
        return "FORM " + mLabel;
    }

}
