package edu.uva.softwarecons.ui.question;

import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.value.ArithmeticValue;
import edu.uva.softwarecons.model.value.IntegerValue;
import edu.uva.softwarecons.model.value.Value;
import javafx.scene.text.Text;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class ComputedQuestionHBox
    extends QuestionHBox
{

    private final Text result = new Text( "0" );

    public ComputedQuestionHBox( BasicQuestion question )
    {
        super( question );
        getChildren().add( result );
    }

    @Override
    public ArithmeticValue getValue()
    {
        //TODO make return work for decimal and currency values
        return new IntegerValue( Integer.parseInt( result.getText() ) );
    }

    @Override
    public void updateValue( Value value )
    {
        this.result.setText( value.getValue().toString() );
    }

}
