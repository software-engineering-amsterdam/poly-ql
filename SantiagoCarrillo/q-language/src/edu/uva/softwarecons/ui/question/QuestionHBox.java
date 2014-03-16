package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.value.Value;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public abstract class QuestionHBox extends HBox {

    private final Label questionLabel;

    protected QuestionHBox(BasicQuestion question) {
        questionLabel = new Label(question.getText());
        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);
        getChildren().add(questionLabel);
    }

    public abstract Value getValue();

    public abstract void updateValue(Value value);

}
