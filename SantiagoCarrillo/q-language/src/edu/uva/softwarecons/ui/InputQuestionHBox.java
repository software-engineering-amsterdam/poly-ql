package edu.uva.softwarecons.ui;

import edu.uva.softwarecons.model.question.BasicQuestion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class InputQuestionHBox extends QuestionHBox{

    private final TextField textField;

    protected InputQuestionHBox(BasicQuestion question, boolean textFieldDisabled) {
        super(question);
        textField = new TextField();
        textField.setDisable(textFieldDisabled);
        getChildren().add(textField);
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.print(textField.getText());
            }
        });
    }

    @Override
    public String getValue() {
        return textField.getText();
    }
}
