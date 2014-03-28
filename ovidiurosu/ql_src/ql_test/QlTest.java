package ql_test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ql_test.ast.AstTest;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public abstract class QlTest
{
    public static final String testFilesPath = System.getProperty("user.dir") +
        File.separator + "src" + File.separator + "ql_test" + File.separator +
        "parser_test_files" + File.separator;

    public static final String expectedResultsPath = System.getProperty("user.dir") +
        File.separator + "src" + File.separator + "ql_test" + File.separator +
        "expected_results" + File.separator;

    protected final File _testFile;
    protected final File _expectedResultFile;

    /**
     * JUnit Test Runner will instantiate this class once for every element
     *     in the Collection returned by the method annotated with @Parameters
     */
    public QlTest(File in, File out)
    {
        this._testFile = in;
        this._expectedResultFile = out;
    }

    public static String readFile(File file, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }

    public static boolean checkFile(File file)
    {
        if (!file.isFile() || !file.canRead()) {
            fail("ATTENTION! This '" + file.getAbsolutePath() + "' is not a readable file!");
            return false;
        }
        return true;
    }

    public static Collection<Object[]> getData(String directoryName)
    {
        Collection<Object[]> data = new ArrayList<Object[]>();

        String testFilesPath =
            AstTest.testFilesPath + directoryName + File.separator;
        String expectedResultsPath =
            AstTest.expectedResultsPath + directoryName + File.separator;

        File directory = new File(testFilesPath);
        if (!directory.isDirectory()) {
            fail("ATTENTION! The test files path '" + testFilesPath +
                 "' is not a directory!");
            return data;
        }

        File[] listOfFiles = directory.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            File in = listOfFiles[i];
            File out = new File(expectedResultsPath + in.getName());
            data.add(new Object[] {in, out});
        }

        return data;
    }
}
