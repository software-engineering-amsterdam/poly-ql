package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.value.DateValue;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.ui.widget.DatePicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Locale;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/16/14
 */
public class DateQuestionHBox
    extends QuestionHBox
{

    private final DatePicker datePicker;

    public DateQuestionHBox( BasicQuestion question, EventHandler<ActionEvent> eventHandler )
    {
        super( question );
        datePicker = new DatePicker( Locale.ENGLISH, eventHandler, question.getId() );
        datePicker.setDateFormat( DateValue.dateFormat );
        datePicker.getCalendarView().todayButtonTextProperty().set( "Today" );
        datePicker.getCalendarView().setShowWeeks( false );
        datePicker.getStylesheets().add( "DatePicker.css" );
        datePicker.setId( question.getId() );
        getChildren().add( datePicker );
    }

    @Override
    public DateValue getValue()
    {
        return new DateValue( datePicker.getSelectedDate() );
    }

    @Override
    public void updateValue( Value value )
    {
    }
}
