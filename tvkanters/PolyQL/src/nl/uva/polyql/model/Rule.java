package nl.uva.polyql.model;

public abstract class Rule {

    private final RuleContainer mParent;

    protected Rule(final RuleContainer parent) {
        mParent = parent;
    }

    public RuleContainer getParent() {
        return mParent;
    }

}
