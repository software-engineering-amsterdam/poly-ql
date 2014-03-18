package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.element.ASTNode;
import main.nl.uva.parser.element.validation.ASTValidation;
import main.nl.uva.parser.element.validation.Scope;
import main.nl.uva.parser.ui.UIElement;
import main.nl.uva.ui.UI;

public abstract class Statement extends ASTNode {

    @Override
    public abstract ASTValidation validate(Scope scope);

    public abstract UIElement getLayout(final UI parentUI);

    public abstract void removeYourselfFromScope(Scope scope);
}
