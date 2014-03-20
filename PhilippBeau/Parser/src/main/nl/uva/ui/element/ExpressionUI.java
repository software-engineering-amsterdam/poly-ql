package main.nl.uva.ui.element;

import main.nl.uva.parser.expression.Variable;
import main.nl.uva.ui.UI;

public class ExpressionUI extends DeclarationUI {

    public ExpressionUI(final Variable variable, final String function, final UI parentUI) {
        super(variable, function, parentUI);
        _valueUI.setEditable(false);
    }

    @Override
    public void onChange(final boolean newValue) {
        recalculateForm();
    }

    @Override
    public void onChange(final double newValue) {
        recalculateForm();
    }

    @Override
    public void onChange(final String newValue) {
        recalculateForm();
    }
}
