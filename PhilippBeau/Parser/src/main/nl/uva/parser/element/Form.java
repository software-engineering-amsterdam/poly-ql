package main.nl.uva.parser.element;

import java.util.List;

import main.nl.uva.parser.element.statement.Statement;
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
    public ASTValidation validate(final Scope scope) {
        return validateChildren(new ASTValidation(), _children, scope);
    }

    public UIElement getLayout(final Form form, final UI parentUI) {
        return new FormUI(form, _children, parentUI);
    }

    @Override
    public String toString() {
        String erg = _id + "\n";

        for (Statement child : _children) {
            erg += child + "\n";
        }

        return erg;
    }
}
