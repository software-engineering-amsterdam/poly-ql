package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.element.ASTNode;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.UIElement;

public abstract class Statement extends ASTNode {

    @Override
    public abstract ASTValidation validate(Scope scope);

    public abstract UIElement getLayout(final UI parentUI);

    public abstract void removeYourselfFromScope(Scope scope);
}
