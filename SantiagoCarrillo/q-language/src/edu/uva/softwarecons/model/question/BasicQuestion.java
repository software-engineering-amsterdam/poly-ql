package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class BasicQuestion implements Question {

    private String id;

    private String text;

    private Type type;


    public BasicQuestion(String id, String text, Type type) {
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
        return "question ( "+id+": "+text+" "+ (null != type ? type.toString() : "" ) +" )";
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
