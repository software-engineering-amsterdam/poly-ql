package main.nl.uva.parser.statement;

import main.nl.uva.parser.ASTNode;
import main.nl.uva.parser.Line;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

public abstract class Statement extends ASTNode {

    public Statement(final Line lineInfo) {
        super(lineInfo);
    }

    @Override
    public abstract ASTValidation validateAndCalculate(Scope scope);

    public abstract UIElement getLayout(final UI parentUI);

    public abstract void removeYourselfFromScope(Scope scope);
}
