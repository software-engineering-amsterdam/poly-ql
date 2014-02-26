package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.expression.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class IfQuestion extends Question {

    Expression expression;

    List<Question> questions = new ArrayList<Question>();

    public IfQuestion() {
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
