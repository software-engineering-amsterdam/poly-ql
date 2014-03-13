package edu.uva.softwarecons.ui;

import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import javafx.scene.text.Text;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class ComputedQuestionHBox extends QuestionHBox{

    private final Text result = new Text();

    protected ComputedQuestionHBox(BasicQuestion question) {
        super(question);
        getChildren().add(result);
    }

    @Override
    public String getValue() {
        return result.getText();
    }

    public void setResult(String result){
        this.result.setText(result);
    }
}
