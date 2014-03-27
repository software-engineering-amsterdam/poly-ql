package main.nl.uva.parser;

import java.util.List;

import main.nl.uva.parser.statement.Statement;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.FormUI;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

public class Form extends ASTNode {

    private final List<Statement> _children;

    private final String _id;

    public Form(final String id, final List<Statement> children, final Line lineInfo) {
        super(lineInfo);
        _id = id;
        _children = children;
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
        return validateChildren(new ASTValidation(), _children, scope);
    }

    public UIElement getLayout(final UI parentUI) {
        return new FormUI(this, _children, parentUI);
    }

    @Override
    public String toString() {
        return "Form " + _id;
    }
}
