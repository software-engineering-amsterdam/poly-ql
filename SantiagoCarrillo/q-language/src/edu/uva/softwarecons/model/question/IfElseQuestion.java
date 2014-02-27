package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class IfElseQuestion extends IfQuestion {

    public List<Question> elseQuestions = new ArrayList<Question>();

    public IfElseQuestion() {
    }

    public void addElseQuestion(Question question){
        elseQuestions.add(question);
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitIfElseQuestion(this);
    }

}
