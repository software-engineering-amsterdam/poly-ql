package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.ui.DeclarationUIElement;
import main.nl.uva.parser.elements.ui.types.ValueUI;

public class Invalid extends Value {

    public Invalid() {
        super(Value.Type.INVALID);
    }

    @Override
    public Expression getAtom() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInvalid() {
        return true;
    }

    @Override
    public Value visit(final Expression right, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value accept(final Bool left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value accept(final Money left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public Value accept(final Text left, final AdvancedExpression expression) {
        return new Invalid();
    }

    @Override
    public ValueUI getLayout(final DeclarationUIElement parent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean visitType(final Value type) {
        throw new UnsupportedOperationException();
    }

}
