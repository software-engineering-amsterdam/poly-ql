package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.element.expression.Variable;
import main.nl.uva.parser.ui.ExpressionUIElement;
import main.nl.uva.parser.ui.UIElement;
import main.nl.uva.ui.UI;

public class ExpressionStatement extends DeclarationStatement {

    public ExpressionStatement(final Variable variable, final String function) {
        super(variable, function);
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new ExpressionUIElement(_variable, _function, parentUI);
    }

}
