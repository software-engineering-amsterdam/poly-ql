package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.type.Variable.Types;

public class ExpressionStatement extends Statement {

    private final Types _type;

    private final String _function;

    private final Expression _expression;

    public ExpressionStatement(final String id, final Types type, final String function,
            final Expression expression) {
        super(id);

        _expression = expression;
        _function = function;
        _type = type;
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }

    @Override
    public void print() {
        System.out.print(_id + " " + _function + " : " + _type + "( ");
        _expression.print();
        System.out.println(" )");
    }
}
