package main.nl.uva.parser.elements.type;

import java.awt.Component;

import javax.swing.JTextField;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.TextAtom;

public class Text extends Type {

    public Text() {
        super(Type.Of.TEXT);
    }

    @Override
    public Expression getAtom() {
        return new TextAtom();
    }

    @Override
    public Type visit(final Expression right, final AdvancedExpression expression) {
        return right.getType().accept(this, expression);
    }

    @Override
    public Type accept(final Bool left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Type accept(final Money left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Type accept(final Text left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Component getLayout() {
        return new JTextField();
    }
}
