package nl.uva.polyql.model;

import java.util.List;

public abstract class Rule {

    private final RuleContainer mParent;

    protected Rule(final RuleContainer parent) {
        mParent = parent;
    }

    public RuleContainer getParent() {
        return mParent;
    }

    public abstract List<Question> getQuestions();

}
