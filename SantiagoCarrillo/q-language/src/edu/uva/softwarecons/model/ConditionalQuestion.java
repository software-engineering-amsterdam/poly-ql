package edu.uva.softwarecons.model;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class ConditionalQuestion extends Question{

    private Expression expression;

    public ConditionalQuestion(String id, String label) {
        super(id, label);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
