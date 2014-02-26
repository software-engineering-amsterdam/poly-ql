package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import nl.uva.polyql.Log;

public class Form extends RuleContainer {

    private final String mLabel;
    private final Set<String> mLabels = new HashSet<>();
    private final List<String> mWarnings = new LinkedList<>();

    public Form(final String label) {
        super(null);

        mLabel = label;
    }

    @Override
    public boolean addLabel(final String label) {
        if (mLabels.contains(label)) {
            addWarning("Label \"" + label + "\" is already used");
            return false;
        }

        mLabels.add(label);
        return true;
    }

    @Override
    public String toString() {
        return "FORM " + mLabel;
    }

    private void addWarning(final String warning) {
        mWarnings.add(warning);
        Log.e("Warning: " + warning);
    }

    public List<String> getWarnings() {
        return mWarnings;
    }

}
