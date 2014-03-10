package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class IfQuestion implements Question {

    private final Expression expression;

    private final List<Question> questions;

    private final ElseQuestion elseQuestion;

    public IfQuestion(Expression expression, List<Question> questions, ElseQuestion elseQuestion) {
        this.expression = expression;
        this.questions = questions;
        this.elseQuestion = elseQuestion;
    }

    public Expression getExpression() {
        return expression;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public ElseQuestion getElseQuestion() {
        return elseQuestion;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitIfQuestion(this);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof IfQuestion;
    }
}
