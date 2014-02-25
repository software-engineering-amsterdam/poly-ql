package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.Log;

public class Form extends RuleContainer {

    private final String mLabel;
    private final Set<String> mLabels = new HashSet<>();

    public Form(final String label) {
        super(null);

        mLabel = label;
    }

    @Override
    public boolean addLabel(final String label) {
        if (mLabels.contains(label)) {
            Log.e("Warning: Label \"" + label + "\" is already used");
            return false;
        }

        mLabels.add(label);
        return true;
    }

    @Override
    public String toString() {
        return "FORM " + mLabel;
    }

}
