package edu.uva.softwarecons.ui.widget;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class TitleHBox
    extends HBox
{


    public TitleHBox( String name, String backgroundColorHex, Paint textColor )
    {
        setPadding( new Insets( 15, 12, 20, 12 ) );
        setSpacing( 10 );
        setStyle( "-fx-background-color: " + backgroundColorHex + ";" );
        Text titleText = new Text( name );
        titleText.setFont( Font.font( "Tahoma", FontWeight.NORMAL, 20 ) );
        titleText.setFill( textColor );
        getChildren().add( titleText );
    }


}
