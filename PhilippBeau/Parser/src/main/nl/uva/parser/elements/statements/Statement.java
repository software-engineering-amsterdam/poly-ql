package main.nl.uva.parser.elements.statements;

public abstract class Statement {

    protected final String _id;

    protected Statement _parent;

    public Statement(final String id) {
        _id = id;
    }

    public void setParent(final Statement parent) {
        _parent = parent;
    }

    protected boolean isSameID(final Statement statement) {
        return _id.equals(statement._id);
    }

    public final boolean validate() {
        return true;
        // Boolean valid = true;
        // for (Statement child : _childrens) {
        // valid = valid && child.validate();
        // }
        //
        // return valid && validateImpl();
    }

    protected abstract boolean validateImpl();

    public final boolean validates(final Statement statement) {
        boolean valid = this.isSameID(statement);

        if (!valid) {
            // for (Statement child : _childrens) {
            // if (child.equals(statement)) {
            // continue;
            // }
            //
            // if (child.isSameID(statement)) {
            // return true;
            // }
            // }

            if (_parent != null) {
                valid = _parent.validates(statement);
            }
        }

        return valid;
    }

    public abstract void print();
}
