package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.value.BooleanValue;
import edu.uva.softwarecons.model.value.Value;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class BooleanQuestionHBox extends QuestionHBox {

    private final CheckBox checkBox = new CheckBox("Yes");

    public BooleanQuestionHBox(String questionId, EventHandler<ActionEvent> eventHandler) {
        super(questionId);
        getChildren().add(checkBox);
        checkBox.setOnAction(eventHandler);
        checkBox.setId(questionId);
    }

    @Override
    public BooleanValue getValue() {
        return new BooleanValue(checkBox.isSelected());
    }

    @Override
    public void updateValue(Value value) {
        checkBox.setSelected(Boolean.valueOf(value.getValue()));
    }


}
