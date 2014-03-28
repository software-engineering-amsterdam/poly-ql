package ql_test.parser;

import java.io.File;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public class FormsTest extends ParserTest
{
    public FormsTest(File in, File out)
    {
        super(in, out);
    }

    @Parameters(name="{0}")
    public static Collection<Object[]> generateData()
    {
        return ParserTest.getData("forms");
    }

    @Test
    public void testBuildParseTree()
    {
        this._parserTest();
    }
}
