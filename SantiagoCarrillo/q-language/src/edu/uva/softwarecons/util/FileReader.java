package edu.uva.softwarecons.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/6/14
 */
public class FileReader
{

    public static String getFileContent( String fileName, String subFolder )
        throws IOException
    {
        final String endOfFile = System.getProperty( "line.separator" );
        final String lineSeparator = System.getProperty( "file.separator" );
        List<String> lines =
            Files.readAllLines( Paths.get( subFolder + lineSeparator + fileName ), Charset.defaultCharset() );
        StringBuilder sb = new StringBuilder();
        for ( String line : lines )
        {
            sb.append( line ).append( endOfFile );
        }
        return sb.toString();
    }
}
