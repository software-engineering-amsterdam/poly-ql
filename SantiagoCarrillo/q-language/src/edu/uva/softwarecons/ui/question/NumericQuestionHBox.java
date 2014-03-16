package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.value.IntegerValue;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.ui.widget.NumericTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/15/14
 */
public class NumericQuestionHBox extends InputQuestionHBox{

    public NumericQuestionHBox(String questionId, boolean textFieldDisabled, EventHandler<ActionEvent> eventHandler) {
        super(questionId, textFieldDisabled, eventHandler, new NumericTextField());
        textField.setText("0");

    }

    @Override
    public Value getValue() {
        return new IntegerValue(Integer.parseInt(textField.getText()));
    }
}
