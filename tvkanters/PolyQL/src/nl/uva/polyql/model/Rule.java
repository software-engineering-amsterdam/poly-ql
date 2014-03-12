package nl.uva.polyql.model;

import java.util.List;

public interface Rule extends VisibilityListener {

    RuleContainer getParent();

    abstract List<Question> getQuestions();

    abstract boolean isVisible();

}
