package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class ComputedQuestion extends Question {

    public Expression expression;

    public ComputedQuestion(String id, String text, Type type, Expression expression) {
        super(id, text, type);
        this.expression = expression;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitComputedQuestion(this);
    }
}
