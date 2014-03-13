package edu.uva.softwarecons.ui;

import edu.uva.softwarecons.model.question.BasicQuestion;
import javafx.scene.control.CheckBox;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class BooleanQuestionHBox extends QuestionHBox {

    private final CheckBox checkBox = new CheckBox("Yes");

    protected BooleanQuestionHBox(BasicQuestion question) {
        super(question);
        getChildren().add(checkBox);

    }

    @Override
    public String getValue() {
        return String.valueOf(checkBox.isSelected());
    }


}
