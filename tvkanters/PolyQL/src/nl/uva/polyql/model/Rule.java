package nl.uva.polyql.model;

import java.util.List;

public abstract class Rule implements VisibilityListener {

    private final RuleContainer mParent;

    protected Rule(final RuleContainer parent) {
        mParent = parent;
    }

    public RuleContainer getParent() {
        return mParent;
    }

    public abstract List<Question> getQuestions();

    public abstract boolean isVisible();

}
