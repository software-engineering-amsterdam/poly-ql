package ql_test.parser;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ql.main.Parser;
import ql_test.QlTest;
import antlr4_ql.QLParser;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public abstract class ParserTest extends QlTest
{
    public ParserTest(File in, File out)
    {
        super(in, out);
    }

    public ParseTree createParseTree(Parser parser)
    {
        return parser.forms();
    }

    protected void _parserTest()
    {
        if (!QlTest.checkFile(this._testFile)) { return; }
        if (!QlTest.checkFile(this._expectedResultFile)) { return; }

        try {
            Parser parser = new Parser();
            QLParser qlParser = parser.buildQLParser(this._testFile);
            ParseTree parseTree = this.createParseTree(parser);

            String in = parseTree.toStringTree(qlParser);
            String out = QlTest.readFile(this._expectedResultFile, StandardCharsets.UTF_8);

            org.junit.Assert.assertEquals(
                "FAIL! The input and the output values should be equal!", in, out);
        } catch (IOException exc) {
            fail("ATTENTION! " + exc.getMessage());
        }
    }
}
