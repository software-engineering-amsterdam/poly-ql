package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.element.ASTNode;
import main.nl.uva.parser.element.Line;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

public abstract class Statement extends ASTNode {

    public Statement(final Line lineInfo) {
        super(lineInfo);
    }

    @Override
    public abstract ASTValidation validate(Scope scope);

    public abstract UIElement getLayout(final UI parentUI);

    public abstract void removeYourselfFromScope(Scope scope);
}
