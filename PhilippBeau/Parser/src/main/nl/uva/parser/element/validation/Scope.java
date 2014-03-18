package main.nl.uva.parser.element.validation;

import java.util.HashMap;

import main.nl.uva.parser.element.expression.Variable;

public class Scope {

    private final HashMap<String, Variable> _currentScope = new HashMap<>();

    public boolean containsVariable(final String variableName) {
        return _currentScope.containsKey(variableName);
    }

    public Variable getVariableFromScope(final String variableName) {
        return _currentScope.get(variableName);
    }

    public void addToScope(final Variable variable) {
        _currentScope.put(variable.getName(), variable);
    }

    public void removeFromScope(final Variable variable) {
        _currentScope.remove(variable.getName());
    }
}
