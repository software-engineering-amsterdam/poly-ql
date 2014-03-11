package main.nl.uva.parser.elements.expressions;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.atoms.VariableAtom;
import main.nl.uva.parser.elements.type.Type;

public class Variable extends Expression {

    private final String _name;

    private final Expression _value;

    private final List<VariableAtom> _linkedVariables = new ArrayList<>();

    public Variable(final Type type, final String name, final Expression value) {
        _type = type;
        _name = name;
        _value = value;

        _value.setParent(this);
    }

    public Variable(final Type type, final String name) {
        this(type, name, type.getAtom());
    }

    @Override
    public String toString() {
        return "( " + _type.toString() + " " + _name + " " + _value + " )";
    }

    @Override
    public List<ValidationError> validate() {
        return _value.validate();
    }

    public String getName() {
        return _name;
    }

    @Override
    public Type getType() {
        return _value.getType();
    }

    public boolean setLinkedVariable(final VariableAtom linkedVariable) {
        return _linkedVariables.add(linkedVariable);
    }

    public void addStuff(final JPanel panel) {
        panel.add(_value.getType().getLayout());
    }

    @Override
    public Object getResult() {
        return _value.getResult();
    }
}
