package edu.uva.softwarecons.model.question;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class IfElseQuestion extends IfQuestion {

    List<Question> elseQuestions = new ArrayList<Question>();

    public IfElseQuestion() {
    }

    public void addElseQuestion(Question question){
        elseQuestions.add(question);
    }

}
