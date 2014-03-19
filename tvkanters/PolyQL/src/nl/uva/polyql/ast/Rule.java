package nl.uva.polyql.ast;

import java.awt.Component;

import nl.uva.polyql.validation.ValidationErrors;

public interface Rule extends AstComponent {

    /**
     * Validates the rule and updates its values upon success.
     * 
     * @return The errors found (empty if none)
     */
    ValidationErrors validate();

    Component getView();

}
