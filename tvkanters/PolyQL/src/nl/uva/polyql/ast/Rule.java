package nl.uva.polyql.ast;

import java.util.List;

import nl.uva.polyql.validation.ValidationErrors;

public interface Rule extends VisibilityListener, AstComponent {

    RuleContainer getParent();

    List<Question> getQuestions();

    boolean isVisible();

    ValidationErrors validate();

}
