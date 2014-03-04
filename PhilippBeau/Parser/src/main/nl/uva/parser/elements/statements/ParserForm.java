package main.nl.uva.parser.elements.statements;

import java.util.List;

public class ParserForm extends Statement {

    private final List<Statement> _children;

    public ParserForm(final String id, final List<Statement> children) {
        super(id);

        _children = children;
    }

    @Override
    public String toString() {
        return _id;
    }

    @Override
    protected boolean validateImpl() {
        return true;
    }

    @Override
    public void print() {
        System.out.println(_id + " " + _children.size());

        for (Statement st : _children) {
            st.print();
        }
    }
}
