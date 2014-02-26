package edu.uva.softwarecons.model;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class ComputedQuestion extends Question {

    Expression expression;

    public ComputedQuestion(String id, String label) {
        super(id, label);
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
