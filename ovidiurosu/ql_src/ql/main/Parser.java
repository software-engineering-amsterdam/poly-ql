package ql.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr4_ql.QLLexer;
import antlr4_ql.QLParser;

/**
 * @author orosu
 */
public class Parser
{
    private QLParser _qlParser;
    private ParseTree _parseTree;

    public Parser()
    {
    }

    public QLParser buildQLParser(File file) throws IOException
    {
        FileInputStream fis = new FileInputStream(file);
        ANTLRInputStream input = new ANTLRInputStream(fis);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        this._qlParser = new QLParser(tokens);
        return this._qlParser;
    }

    public ParseTree buildParseTree()
    {
        // begin parsing at initialize rule
        this._parseTree = this._qlParser.initialize();
        return this._parseTree;
    }
}
