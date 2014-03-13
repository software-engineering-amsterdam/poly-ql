package nl.uva.polyql.model;

import java.util.List;

import nl.uva.polyql.validation.ValidationErrors;

public interface Rule extends VisibilityListener {

    RuleContainer getParent();

    abstract List<Question> getQuestions();

    abstract boolean isVisible();

    abstract ValidationErrors validate();

}
