package main.nl.uva.parser.element;

import java.util.List;

import main.nl.uva.parser.element.statement.Statement;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;

public abstract class ASTNode {

    public abstract ASTValidation validate(final Scope scope);

    protected static ASTValidation validateChildren(final ASTValidation valid, final List<Statement> statements, final Scope scope) {
        for (Statement child : statements) {
            valid.combine(child.validate(scope));
        }

        return valid;
    }
}
