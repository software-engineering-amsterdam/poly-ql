package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.value.StringValue;
import edu.uva.softwarecons.model.value.Value;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.SwipeEvent;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class InputQuestionHBox extends QuestionHBox{

    protected final TextField textField;

    public InputQuestionHBox(String questionId, boolean textFieldDisabled, EventHandler<ActionEvent> eventHandler,  TextField textField) {
        super(questionId);
        this.textField = textField;
        textField.setDisable(textFieldDisabled);
        getChildren().add(textField);
        textField.setId(questionId);
        textField.setOnAction(eventHandler);
    }

    @Override
    public Value getValue() {
        return new StringValue(textField.getText());
    }

    @Override
    public void updateValue(Value value) {
        textField.setText(value.getValue());
    }
}
