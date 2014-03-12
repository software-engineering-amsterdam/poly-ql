package main.nl.uva.parser.elements.ui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;
import main.nl.uva.parser.elements.expressions.atoms.TextAtom;
import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Text;
import main.nl.uva.parser.elements.ui.types.ValueUI;

public class DeclarationUIElement extends UIElement implements UIValueChangeListener {

    private final String _function;

    private final Variable _variable;

    public DeclarationUIElement(final Variable variable, final String function) {
        _function = function;
        _variable = variable;
    }

    @Override
    public JPanel generateUIElement() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.X_AXIS));
        JLabel label = new JLabel(_function);
        layout.add(label);

        ValueUI valueUI = _variable.getType().getLayout(this);
        layout.add(valueUI.getComponent());

        return layout;
    }

    @Override
    public void onChange(final boolean newValue) {
        _variable.setExpression(new BoolAtom(new Bool(newValue)));
    }

    @Override
    public void onChange(final double newValue) {
        _variable.setExpression(new MoneyAtom(new Money(newValue)));
    }

    @Override
    public void onChange(final String newValue) {
        _variable.setExpression(new TextAtom(new Text(newValue)));
    }

}
