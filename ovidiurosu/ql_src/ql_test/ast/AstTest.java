package ql_test.ast;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ql.ast.AstBuilderVisitor;
import ql.ast.QuestionnaireList;
import ql.main.Parser;
import ql_test.QlTest;

/**
 * @author orosu
 */
@RunWith(Parameterized.class)
public abstract class AstTest extends QlTest
{
    public AstTest(File in, File out)
    {
        super(in, out);
    }

    public ParseTree createParseTree(Parser parser)
    {
        return parser.forms();
    }

    public QuestionnaireList visitParseTree(AstBuilderVisitor buildAstVisitor,
        ParseTree parseTree)
    {
        return (QuestionnaireList) buildAstVisitor.visit(parseTree);
    }

    protected void _astTest()
    {
        if (!QlTest.checkFile(this._testFile)) { return; }
        if (!QlTest.checkFile(this._expectedResultFile)) { return; }

        try {
            Parser parser = new Parser();
            parser.buildQLParser(this._testFile);
            ParseTree parseTree = this.createParseTree(parser);

            AstBuilderVisitor buildAstVisitor = new AstBuilderVisitor();

            // Build LISP-like tree and compare the String result with the expected result (from file)
            String in = QlTest.readFile(this._expectedResultFile, StandardCharsets.UTF_8);
            String out = buildAstVisitor.visit(parseTree).toString();

            org.junit.Assert.assertEquals(
                "FAIL! The input and the output values should be equal!", in, out);
        } catch (IOException exc) {
            fail("ATTENTION! " + exc.getMessage());
        }
    }
}
