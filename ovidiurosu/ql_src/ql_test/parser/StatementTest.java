package ql_test.parser;

import java.io.File;
import java.util.Collection;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.main.Parser;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public class StatementTest extends ParserTest
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
        return ParserTest.getData("statement");
    }

    @Test
    public void testBuildParseTree()
    {
        this._parserTest();
    }
}
