package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.element.expression.Variable;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.ExpressionUI;
import main.nl.uva.ui.element.UIElement;

public class ExpressionStatement extends DeclarationStatement {

    public ExpressionStatement(final Variable variable, final String function) {
        super(variable, function);
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new ExpressionUI(_variable, _function, parentUI);
    }

}
