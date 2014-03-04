package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Expression;

public class IFStatement extends Statement {

    protected final List<Statement> _children;

    private final Expression _expression;

    public IFStatement(final Expression expression, final List<Statement> children) {
        super("");

        _expression = expression;
        _children = children;
    }

    @Override
    protected boolean validateImpl() {
        boolean valid = _parent.validates(this);

        if (!valid) {
            System.err.println(this + " -> is very very wrong");
        }

        return valid;
    }

    @Override
    public String toString() {
        return "IFStatement " + _id;
    }

    @Override
    public void print() {
        System.out.print(_id + " ");
        _expression.print();
        System.out.println(_children.size());

        for (Statement st : _children) {
            st.print();
        }
    }
}
