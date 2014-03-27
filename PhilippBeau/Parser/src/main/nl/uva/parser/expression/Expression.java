package main.nl.uva.parser.expression;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.ASTNode;
import main.nl.uva.parser.Line;
import main.nl.uva.validation.type.Value;

public abstract class Expression extends ASTNode {

    private final List<ExpressionChangeListener> _listener = new ArrayList<>();

    public Expression(final Line lineInfo) {
        super(lineInfo);
    }

    public boolean registerListener(final ExpressionChangeListener listener) {
        return _listener.add(listener);
    }

    protected void notifyListenersAboutValueChange() {
        for (ExpressionChangeListener listener : _listener) {
            listener.onChange();
        }
    }

    public abstract Value getValue();
}