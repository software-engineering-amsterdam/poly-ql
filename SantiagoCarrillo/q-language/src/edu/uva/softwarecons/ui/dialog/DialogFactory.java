package edu.uva.softwarecons.ui.dialog;

import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.ui.widget.TitleHBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/16/14
 */
public class DialogFactory
{

    public static void showErrorDialog( String title, String message )
    {
        Stage dialogStage = new Stage();
        dialogStage.setTitle( title );
        dialogStage.initModality( Modality.WINDOW_MODAL );
        VBox vBox = new VBox( 25 );
        vBox.setAlignment( Pos.CENTER );
        Label messageText = new Label( message );
        messageText.setWrapText( true );
        vBox.getChildren().add( messageText );
        final Scene scene = new Scene( vBox, 290, 100 );
        Button button = new Button( "OK" );
        button.setOnAction( new EventHandler<ActionEvent>()
        {
            @Override
            public void handle( ActionEvent actionEvent )
            {
                Stage stage = (Stage) scene.getWindow();
                stage.close();
            }
        } );
        vBox.getChildren().add( button );
        dialogStage.setScene( scene );
        dialogStage.show();
    }


    public static void showQuestionnaireErrorDialog( List<QuestionnaireError> errors )
    {
        Stage dialogStage = new Stage();
        dialogStage.setTitle( "Error loading file" );
        dialogStage.initModality( Modality.WINDOW_MODAL );
        VBox vBox = new VBox();
        vBox.getChildren().add( new TitleHBox( "Errors Found:", "#ffffb2", Color.RED ) );
        Scene scene = new Scene( vBox, 600, 400 );
        dialogStage.setScene( scene );
        dialogStage.show();
        for ( QuestionnaireError error : errors )
        {
            Text text = new Text( error.toString() );
            text.setFill( Color.RED );
            vBox.getChildren().add( text );
        }
    }
}
