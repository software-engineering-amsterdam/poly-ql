package main.nl.uva.ui.element;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.nl.uva.parser.expression.ExpressionChangeListener;
import main.nl.uva.parser.expression.Variable;
import main.nl.uva.parser.expression.unary.UnaryExpression;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.UIValueChangeListener;
import main.nl.uva.ui.types.ValueUI;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Text;

public class DeclarationUI extends UIElement implements UIValueChangeListener, ExpressionChangeListener {

    private final String _function;

    private final Variable _variable;

    protected ValueUI _valueUI;

    private final JPanel _panel;

    public DeclarationUI(final Variable variable, final String function, final UI parentUI) {
        super(parentUI);

        _function = function;
        _variable = variable;
        _variable.registerListener(this);

        _panel = generateDeclarationPanel();
    }

    private JPanel generateDeclarationPanel() {
        JPanel layout = generateXAxisPanel();
        JLabel label = new JLabel(_function);
        layout.add(label);

        _valueUI = _variable.getUserInterfaceRepresentation(this);
        layout.add(_valueUI.getComponent());

        return layout;
    }

    @Override
    public JPanel getPanel() {
        return _panel;
    }

    @Override
    public void onChange(final boolean newValue) {
        _variable.setExpression(new UnaryExpression(new Bool(newValue)));
        recalculateForm();
    }

    @Override
    public void onChange(final double newValue) {
        _variable.setExpression(new UnaryExpression(new Money(newValue)));
        recalculateForm();
    }

    @Override
    public void onChange(final String newValue) {
        _variable.setExpression(new UnaryExpression(new Text(newValue)));
        recalculateForm();
    }

    @Override
    public void onChange() {
        _valueUI.valueChange(_variable.getValue());
    }
}
