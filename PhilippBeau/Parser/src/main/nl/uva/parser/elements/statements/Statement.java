package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.ASTNode;
import main.nl.uva.parser.elements.ui.UIElement;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;
import main.nl.uva.ui.UI;

public abstract class Statement extends ASTNode {

    @Override
    public abstract ASTValidation validate(Scope scope);

    public abstract UIElement getLayout(final UI parentUI);

    public abstract void removeYourselfFromScope(Scope scope);
}
