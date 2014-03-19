package main.nl.uva.parser.element.expression;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.element.Line;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.ValueUI;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.InvalidTypeError;
import main.nl.uva.validation.type.Value;

public class Variable extends Expression implements ExpressionChangeListener {

    private final Value.Type _value;

    private final String _name;

    private Expression _expression;

    private final List<ExpressionChangeListener> _listener = new ArrayList<>();

    public Variable(final Value.Type type, final String name, final Expression expression, final Line lineInfo) {
        super(lineInfo);
        _value = type;
        _name = name;
        _expression = expression;

        _expression.registerListener(this);
    }

    public Variable(final Value.Type type, final String name, final Line lineInfo) {
        this(type, name, type.getAtom(), lineInfo);
    }

    @Override
    public boolean registerListener(final ExpressionChangeListener listener) {
        return _listener.add(listener);
    }

    public boolean setExpression(final Expression newExpression) {
        if (!newExpression.getValue().isTypeOf(_value)) {
            // Type is not acceptable
            return false;
        }

        _expression = newExpression;
        _expression.registerListener(this);

        return true;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _expression.validate(scope);

        if (!_expression.getValue().isTypeOf(_value)) {
            valid.addError(new InvalidTypeError(this.toString(), getLineInfo()));
        }

        return valid;
    }

    public String getName() {
        return _name;
    }

    @Override
    public Value getValue() {
        return _expression.getValue();
    }

    public ValueUI getUserInterfaceRepresentation(final DeclarationUI parent) {
        return _expression.getValue().getLayout(parent);
    }

    @Override
    public String toString() {
        return _name;
    }

    @Override
    public void onChange() {

        for (ExpressionChangeListener listener : _listener) {
            listener.onChange();
        }
    }
}
