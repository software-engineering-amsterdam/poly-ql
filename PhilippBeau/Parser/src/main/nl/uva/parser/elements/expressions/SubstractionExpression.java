package main.nl.uva.parser.elements.expressions;

public class SubstractionExpression extends AdvancedExpression {

    public SubstractionExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        _left.print();
        System.out.print(" - ");
        _right.print();
    }
}
