package nl.uva.polyql.ast;

import nl.uva.polyql.ast.expressions.Expression;

public class ElseStatement extends IfStatement {

    protected ElseStatement(final RuleContainer parent, final Expression expression) {
        super(parent, expression);
    }

    @Override
    public boolean isSatisfied() {
        return !super.isSatisfied();
    }

    @Override
    public String toString() {
        return "ELSE " + getExpression();
    }

}
