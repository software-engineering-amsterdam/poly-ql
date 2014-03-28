package main.nl.uva.parser.expression.unary;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.type.Value;

public class UnaryExpression extends Expression {

    protected Value _value = null;

    public UnaryExpression(final Value value, final Line lineInfo) {
        super(lineInfo);

        _value = value;
    }

    public UnaryExpression(final Value value) {
        super(Line.NO_LINE_NUMBER);

        _value = value;
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
        return new ASTValidation();
    }

    @Override
    public Value getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return _value.toString();
    }
}
