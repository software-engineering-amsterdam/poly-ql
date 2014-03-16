package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.value.ArithmeticValue;
import edu.uva.softwarecons.model.value.IntegerValue;
import javafx.scene.Node;
import javafx.scene.text.Text;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class ComputedQuestionHBox extends QuestionHBox{

    private final Text result = new Text("0");

    public ComputedQuestionHBox(String questionId) {
        super(questionId);
        getChildren().add(result);
    }

    @Override
    public ArithmeticValue getValue() {
        //TODO make return work for decimal and currency values
        return new IntegerValue(Integer.parseInt(result.getText()));
    }

    @Override
    public void updateValue(Node node) {
        this.result.setText(((Text) node).getText());
    }

}
