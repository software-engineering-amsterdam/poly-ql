package edu.uva.softwarecons.model;

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

    public String id;

    public List<Question> questions = new ArrayList<Question>();


    public Form(String id) {
        this.id = id;
    }

    public void addQuestion(Question question){
            questions.add(question);
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitForm(this);
    }

}
