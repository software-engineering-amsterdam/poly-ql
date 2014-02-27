package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class IfQuestion extends Question {

    public Expression expression;

    public List<Question> questions = new ArrayList<Question>();

    public IfQuestion() {
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitIfQuestion(this);
    }
}
