package edu.uva.softwarecons.ui.widget;

import javafx.scene.control.TextField;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/15/14
 */
public class NumericTextField
    extends TextField
{


    public void replaceText( int start, int end, String text )
    {
        if ( !text.matches( "[a-z]" ) && !text.matches( "[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+" ) )
        {
            super.replaceText( start, end, text );
        }

    }

    public void replaceSelection( String text )
    {
        if ( !text.matches( "[a-z]" ) && !text.matches( "[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+" ) )
        {
            super.replaceSelection( text );
        }
    }

}
