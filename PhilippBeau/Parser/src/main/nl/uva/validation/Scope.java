package main.nl.uva.validation;

import java.util.HashMap;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Variable;

public class Scope {

    private final HashMap<String, Variable> _variableScope = new HashMap<>();

    private final HashMap<String, Line> _labelScope = new HashMap<>();

    public boolean labelAlreadyDefined(final String label) {
        return _labelScope.containsKey(label);
    }

    public boolean variableAlreadyDefined(final String variableName) {
        return _variableScope.containsKey(variableName);
    }

    public Variable getVariable(final String variableName) {
        return _variableScope.get(variableName);
    }

    public void addToScope(final String label, final Line lineInfo) {
        _labelScope.put(label, lineInfo);
    }

    public void removeFromScope(final String label) {
        _labelScope.remove(label);
    }

    public void addToScope(final Variable variable) {
        _variableScope.put(variable.getName(), variable);
    }

    public void removeFromScope(final Variable variable) {
        _variableScope.remove(variable.getName());
    }
}
