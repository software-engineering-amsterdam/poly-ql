package main.nl.uva.ui.element;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.nl.uva.parser.element.expression.ExpressionChangeListener;
import main.nl.uva.parser.element.expression.Variable;
import main.nl.uva.parser.element.expression.atom.BoolAtom;
import main.nl.uva.parser.element.expression.atom.MoneyAtom;
import main.nl.uva.parser.element.expression.atom.TextAtom;
import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.parser.element.type.Money;
import main.nl.uva.parser.element.type.Text;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.UIValueChangeListener;
import main.nl.uva.ui.types.ValueUI;

public class DeclarationUI extends UIElement implements UIValueChangeListener, ExpressionChangeListener {

    private final String _function;

    private final Variable _variable;

    protected ValueUI _valueUI;

    public DeclarationUI(final Variable variable, final String function, final UI parentUI) {
        super(parentUI);
        _function = function;
        _variable = variable;

        _variable.registerListener(this);
    }

    @Override
    public JPanel generateUIElement() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.X_AXIS));
        JLabel label = new JLabel(_function);
        layout.add(label);

        _valueUI = _variable.getUserInterfaceRepresentation(this);
        layout.add(_valueUI.getComponent());

        return layout;
    }

    @Override
    public void onChange(final boolean newValue) {
        _variable.setExpression(new BoolAtom(new Bool(newValue)));
        recalculateForm();
    }

    @Override
    public void onChange(final double newValue) {
        _variable.setExpression(new MoneyAtom(new Money(newValue)));
        recalculateForm();
    }

    @Override
    public void onChange(final String newValue) {
        _variable.setExpression(new TextAtom(new Text(newValue)));
        recalculateForm();
    }

    @Override
    public void onChange() {
        _valueUI.valueChange(_variable.getValue());
    }
}
