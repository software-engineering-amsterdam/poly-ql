package main.nl.uva.parser.expression;

import main.nl.uva.parser.Line;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.ValueUI;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.InvalidTypeError;
import main.nl.uva.validation.type.Value;

public class Variable extends Expression implements ExpressionChangeListener {

    private final Value.Type _type;

    private final String _name;

    private Expression _expression;

    public Variable(final Value.Type type, final String name, final Expression expression, final Line lineInfo) {
        super(lineInfo);
        _type = type;
        _name = name;
        _expression = expression;

        _expression.registerListener(this);
    }

    public Variable(final Value.Type type, final String name, final Line lineInfo) {
        this(type, name, type.getAtom(), lineInfo);
    }

    public boolean setExpression(final Expression newExpression) {
        if (!newExpression.getValue().isTypeOf(_type)) {
            // Type is not acceptable
            return false;
        }

        _expression = newExpression;
        _expression.registerListener(this);

        return true;
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
        ASTValidation valid = _expression.validateAndCalculate(scope);

        if (!_expression.getValue().isTypeOf(_type)) {
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
        notifyListenersAboutValueChange();
    }
}
