package main.nl.uva.parser.statement;

import main.nl.uva.parser.expression.Variable;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.ExpressionUI;
import main.nl.uva.ui.element.UIElement;

public class FixedDeclaration extends Declaration {

    public FixedDeclaration(final Variable variable, final String function) {
        super(variable, function);
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new ExpressionUI(_variable, _label, parentUI);
    }

}
