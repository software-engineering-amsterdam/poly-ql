package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.value.BooleanValue;
import edu.uva.softwarecons.model.value.Value;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class BooleanQuestionHBox
    extends QuestionHBox
{

    private final CheckBox checkBox = new CheckBox( "Yes" );

    public BooleanQuestionHBox( BasicQuestion question, EventHandler<ActionEvent> eventHandler )
    {
        super( question );
        getChildren().add( checkBox );
        checkBox.setOnAction( eventHandler );
        checkBox.setId( question.getId() );
    }

    @Override
    public BooleanValue getValue()
    {
        return new BooleanValue( checkBox.isSelected() );
    }

    @Override
    public void updateValue( Value value )
    {
        checkBox.setSelected( ( (BooleanValue) value ).getValue() );
    }


}
