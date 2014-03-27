package main.nl.uva.parser;

import java.util.List;

import main.nl.uva.parser.statement.Statement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

public abstract class ASTNode {

    private final Line _lineInfo;

    public ASTNode(final Line lineInfo) {
        _lineInfo = lineInfo;
    }

    public Line getLineInfo() {
        return _lineInfo;
    }

    public abstract ASTValidation validateAndCalculate(final Scope scope);

    protected static ASTValidation validateChildren(final ASTValidation valid, final List<Statement> statements, final Scope scope) {
        for (Statement child : statements) {
            valid.combine(child.validateAndCalculate(scope));
        }

        return valid;
    }
}
