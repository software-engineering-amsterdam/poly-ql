package main.nl.uva.parser.elements.expressions;

public class ComparrisonExpression extends AdvancedExpression {

    public ComparrisonExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        return "ComparrisonExp: ";
    }

    @Override
    public void print() {
        _left.print();
        System.out.print(" == ");
        _right.print();
    }
}
