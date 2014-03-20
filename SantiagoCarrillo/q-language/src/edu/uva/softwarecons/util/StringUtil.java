package edu.uva.softwarecons.util;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.ui.question.QuestionHBox;

import java.util.HashMap;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/16/14
 */
public class StringUtil
{

    public static String formToJson( Form form, HashMap<String, QuestionHBox> questions )
    {
        StringBuffer formData = new StringBuffer();
        formData.append( "{\"" ).append( form.getId() ).append( "\": {" );
        for ( String questionId : questions.keySet() )
        {
            formData.append( "\"" ).append( questionId ).append( "\": " );
//            String value = null;
//            if ( null != questions.get( questionId ).getValue() )
//            {
//                value = questions.get( questionId ).getValue().toString();
//            }
            formData.append( questions.get( questionId ).getValue().toString() );
            formData.append( "," );
        }
        formData.replace( formData.length() - 1, formData.length(), "} }" );
        return formData.toString();
    }
}
