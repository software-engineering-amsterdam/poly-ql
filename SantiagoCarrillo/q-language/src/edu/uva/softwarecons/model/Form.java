package edu.uva.softwarecons.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/25/14
 */
public class Form {

    String id;

    List<Question> questions = new ArrayList<Question>();

    List<ComputedQuestion> computedQuestions = new ArrayList<ComputedQuestion>();

    List<ConditionalQuestion> conditionalQuestions = new ArrayList<ConditionalQuestion>();

    public Form(String id) {
        this.id = id;
    }

    public void addQuestion(Question question){
            questions.add(question);
    }

    public void addConditionalQuestion(ConditionalQuestion question){
        conditionalQuestions.add(question);
    }

    public void addComputedQuestion(ComputedQuestion question){
        computedQuestions.add(question);
    }
}
