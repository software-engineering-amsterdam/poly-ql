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
import org.junit.runners.Parameterized.Parameters;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public abstract class ParserTest
{
    public static final String testFilesPath = System.getProperty("user.dir") + File.separator +
        "src" + File.separator + "ql_test" + File.separator + "parser_test_files" + File.separator;

    public static final String expectedResultsPath = System.getProperty("user.dir") + File.separator +
        "src" + File.separator + "ql_test" + File.separator + "expected_results" + File.separator;

    protected final File _testFile;
    protected final File _expectedResultFile;

    /**
     * JUnit Test Runner will instantiate this class once for every element
     *     in the Collection returned by the method annotated with @Parameters
     */
    public ParserTest(File in, File out)
    {
        this._testFile = in;
        this._expectedResultFile = out;
    }

    /**
     * Test Data Generator
     * This method is called by the JUnit parameterized test runner and
     *     returns a Collection of Arrays. For each Array in the Collection,
     *     each array element corresponds to a parameter in the constructor
     */
    @Parameters(name="{0}")
    public static Collection<Object[]> generateData()
    {
        Collection<Object[]> data = new ArrayList<Object[]>();

        File directory = new File(ParserTest.testFilesPath);
        if (!directory.isDirectory()) {
            fail("ATTENTION! The test files path '" +
                 ParserTest.testFilesPath + "' is not a directory!");
            return data;
        }

        File[] listOfFiles = directory.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            File in = listOfFiles[i];
            File out = new File(ParserTest.expectedResultsPath + in.getName());
            data.add(new Object[] {in, out});
        }

        return data;
    }

    public String readFile(File file, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
