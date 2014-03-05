package edu.uva.softwarecons.model;

import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.visitor.IFormElement;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/25/14
 */
public class Form implements IFormElement {

    private final String id;

    private final List<Question> questions;

    public Form(String id, List<Question> questions) {
        this.id = id;
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitForm(this);
    }

}
