package main.nl.uva.parser.elements.statements;

import java.util.ArrayList;
import java.util.List;

import static main.nl.uva.parser.Utils.available;

public abstract class Statement {

    protected final String _id;

    protected final List<Statement> _childrens = new ArrayList<>();

    protected final Statement _parent;

    public Statement(final String id, final Statement parent) {
        _id = id;
        _parent = parent;

        if (available(_parent)) {
            _parent.addChild(this);
        }
    }

    public void addChild(final Statement statement) {
        _childrens.add(statement);
    }

    protected boolean isSameID(final Statement statement) {
        return _id.equals(statement._id);
    }

    public final boolean validate() {
        Boolean valid = true;
        for (Statement child : _childrens) {
            valid = valid && child.validate();
        }

        return valid && validateImpl();
    }

    protected abstract boolean validateImpl();

    public final boolean validates(final Statement statement) {
        boolean valid = this.isSameID(statement);

        if (!valid) {
            for (Statement child : _childrens) {
                if (child.equals(statement)) {
                    continue;
                }

                if (child.isSameID(statement)) {
                    return true;
                }
            }

            if (_parent != null) {
                valid = _parent.validates(statement);
            }
        }

        return valid;
    }

    public List<Statement> getChildren() {
        return _childrens;
    }
}
