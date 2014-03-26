package ql_test.ast;

import java.io.File;
import java.util.Collection;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.main.Parser;
import ql_test.QlTest;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public class StatementTest extends AstTest
{
    public StatementTest(File in, File out)
    {
        super(in, out);
    }

    @Override
    public ParseTree createParseTree(Parser parser)
    {
        return parser.statement();
    }

    @Parameters(name="{0}")
    public static Collection<Object[]> generateData()
    {
        return QlTest.getData("statement");
    }

    @Test
    public void testBuildParseTree()
    {
        this._astTest();
    }
}
