package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.grammar.QuestionnaireParser;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElement;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class Question implements IFormElement {

    public String id;

    public String text;

    public Type type;

    public Question() {
    }

    public Question(String id, String text, Type type) {
        this.id = id;
        this.text = text;
        this.type = type;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitQuestion(this);
    }

    @Override
    public String toString() {
        return "question ( "+id+": "+text+" "+type.toString()+" )";
    }
}
