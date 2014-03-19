package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.value.StringValue;
import edu.uva.softwarecons.model.value.Value;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class InputQuestionHBox
    extends QuestionHBox
{

    protected final TextField textField;

    public InputQuestionHBox( BasicQuestion question, EventHandler<ActionEvent> eventHandler, TextField textField )
    {
        super( question );
        this.textField = textField;
        getChildren().add( textField );
        textField.setId( question.getId() );
        textField.setOnAction( eventHandler );
    }

    @Override
    public Value getValue()
    {
        return new StringValue( textField.getText() );
    }

    @Override
    public void updateValue( Value value )
    {
        textField.setText( value.getValue().toString() );
    }
}
