package ql_test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ql.main.Parser;
import antlr4_ql.QLParser;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
@Ignore //TODO implement Build AST Test
public class BuildASTTest extends ParserTest
{
    public BuildASTTest(File in, File out)
    {
        super(in, out);
    }

    /**
     * This test method is run once for each element in the Collection returned
     *     by the Test Data Generator
     */
    @Test
    public void testBuildAST()
    {
        if (!this._testFile.isFile() || !this._testFile.canRead()) {
            fail("ATTENTION! This '" + this._testFile.getAbsolutePath() +
                 "' is not a readable file!");
            return;
        }
        if (!this._expectedResultFile.isFile() || !this._expectedResultFile.canRead()) {
            fail("ATTENTION! This '" + this._expectedResultFile.getAbsolutePath() +
                 "' is not a readable file!");
            return;
        }

        try {
            Parser parser = new Parser();
            QLParser qlParser = parser.buildQLParser(this._testFile);
            ParseTree tree = parser.buildParseTree();

            String in = tree.toStringTree(qlParser);
            String out = this.readFile(this._expectedResultFile, StandardCharsets.UTF_8);

            //TODO BuildASTTest implement toString() to build the LISP-like tree
            //TODO BuildASTTest compare the String result with the expected result (from file)
            org.junit.Assert.assertEquals("FAIL! The input and the output values should be equal!", in, out);
        } catch (IOException exc) {
            fail("ATTENTION! " + exc.getMessage());
        }
    }
}
