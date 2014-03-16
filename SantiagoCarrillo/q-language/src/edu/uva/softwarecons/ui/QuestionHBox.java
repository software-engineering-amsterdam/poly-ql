package edu.uva.softwarecons.ui;

import edu.uva.softwarecons.model.value.Value;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public abstract class QuestionHBox extends HBox {

    private final Label questionLabel;

    protected QuestionHBox(String questionId) {
        questionLabel = new Label(questionId);
        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);
        getChildren().add(questionLabel);
    }

    public abstract Value getValue();

    public abstract void updateValue(Node node);

}
