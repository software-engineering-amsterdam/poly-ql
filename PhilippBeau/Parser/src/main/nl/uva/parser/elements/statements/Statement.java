package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.ASTNode;
import main.nl.uva.parser.elements.ui.UIElement;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public abstract class Statement extends ASTNode {

    @Override
    public abstract ASTValidation validate(Scope scope);

    public abstract UIElement getLayout();

    public abstract void removeYourselfFromScope(Scope scope);
}
