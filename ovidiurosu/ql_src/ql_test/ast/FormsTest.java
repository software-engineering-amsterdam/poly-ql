package ql_test.ast;

import java.io.File;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql_test.QlTest;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public class FormsTest extends AstTest
{
    public FormsTest(File in, File out)
    {
        super(in, out);
    }

    @Parameters(name="{0}")
    public static Collection<Object[]> generateData()
    {
        return QlTest.getData("forms");
    }

    @Test
    public void testBuildParseTree()
    {
        this._astTest();
    }
}
