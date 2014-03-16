package nl.uva.polyql.ast;

import java.awt.Component;
import java.util.List;

import nl.uva.polyql.validation.ValidationErrors;

public interface Rule extends AstComponent {

    RuleContainer getParent();

    List<Question> getQuestions();

    ValidationErrors validate();

    Component getView();

}
