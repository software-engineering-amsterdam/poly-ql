package main.nl.uva.parser.element.statement;

import java.util.List;

import main.nl.uva.parser.element.ASTNode;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.FormUI;
import main.nl.uva.ui.element.UIElement;

public class ParserForm extends ASTNode {

    private final List<Statement> _children;

    private final String _id;

    public ParserForm(final String id, final List<Statement> children) {
        _id = id;
        _children = children;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        return validateChildren(new ASTValidation(), _children, scope);
    }

    public UIElement getLayout(final ParserForm form, final UI parentUI) {
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
