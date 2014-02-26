package edu.uva.softwarecons.model.question;

import edu.uva.softwarecons.grammar.QuestionnaireParser;
import edu.uva.softwarecons.model.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class Question {

    private String id;

    private String text;

    private Type type;

    public Question() {
    }

    public Question(String id, String text, Type type) {
        this.id = id;
        this.text = text;
        this.type = type;
    }

    public Question(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
