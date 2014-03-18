package main.nl.uva.parser.elements.ui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.nl.uva.parser.elements.expressions.ExpressionChangeListener;
import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;
import main.nl.uva.parser.elements.expressions.atoms.TextAtom;
import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Text;
import main.nl.uva.parser.elements.ui.types.ValueUI;
import main.nl.uva.ui.UI;

public class DeclarationUIElement extends UIElement implements UIValueChangeListener, ExpressionChangeListener {

    private final String _function;

    private final Variable _variable;

    protected ValueUI _valueUI;

    public DeclarationUIElement(final Variable variable, final String function, final UI parentUI) {
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

        _valueUI = _variable.getValue().getLayout(this);
        _valueUI.valueChange(_variable.getValue());
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
