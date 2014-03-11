package main.nl.uva.parser.elements.statements;

import java.util.List;

import javax.swing.JPanel;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Variable;

public class IfElseStatement extends BlockStatement {

    private final IFStatement _ifStatement;
    private final IFStatement _elseStatement;

    public IfElseStatement(final IFStatement ifStatement, final IFStatement elseStatement) {

        _ifStatement = ifStatement;
        _elseStatement = elseStatement;

        _ifStatement.setParent(this);
        _elseStatement.setParent(this);
    }

    @Override
    public String toString() {
        return _ifStatement.toString() + _elseStatement.toString();
    }

    @Override
    public Variable findVariable(final String variableName, final Statement scopeEnd) {
        return _parent.findVariable(variableName, this);
    }

    @Override
    public List<ValidationError> validate() {
        List<ValidationError> ifStatement = _ifStatement.validate();
        List<ValidationError> elseStatement = _elseStatement.validate();

        ifStatement.addAll(elseStatement);

        return ifStatement;
    }

    @Override
    public JPanel getLayout() {
        return new JPanel();
    }
}
