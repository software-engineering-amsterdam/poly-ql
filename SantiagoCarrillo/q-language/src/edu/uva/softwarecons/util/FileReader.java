package edu.uva.softwarecons.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class FileReader {

    public static String getFileContent(String fileName) throws IOException {
        final String EoL = System.getProperty("line.separator");
        List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append(EoL);
        }
        return sb.toString();
    }
}
