package nl.uva.polyql.model;

import java.util.HashSet;
import java.util.Set;

public class Form extends RuleContainer {

    private final Set<String> mLabels = new HashSet<>();

    public Form() {
        super(null);
    }

    @Override
    public boolean addLabel(final String label) {
        if (mLabels.contains(label)) {
            System.err.println("Warning: Label \"" + label + "\" is already used");
            return false;
        }

        mLabels.add(label);
        return true;
    }

}
