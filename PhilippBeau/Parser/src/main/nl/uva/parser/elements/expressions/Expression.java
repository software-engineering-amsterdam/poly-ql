package main.nl.uva.parser.elements.expressions;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.ASTNode;
import main.nl.uva.parser.elements.type.Value;

public abstract class Expression extends ASTNode {

    private final List<ExpressionChangeListener> _listener = new ArrayList<>();

    public Expression() {}

    public boolean registerListener(final ExpressionChangeListener listener) {
        return _listener.add(listener);
    }

    protected void notifyListeners() {
        for (ExpressionChangeListener listener : _listener) {
            listener.onChange();
        }
    }

    public abstract Value getValue();
}