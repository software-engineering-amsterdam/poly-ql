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

    public ParseTree forms()
    {
        this._parseTree = this._qlParser.forms();
        return this._parseTree;
    }

    public ParseTree block()
    {
        this._parseTree = this._qlParser.block();
        return this._parseTree;
    }

    public ParseTree statement()
    {
        this._parseTree = this._qlParser.statement();
        return this._parseTree;
    }

    public ParseTree expression()
    {
        this._parseTree = this._qlParser.expression(0);
        return this._parseTree;
    }

    public ParseTree type()
    {
        this._parseTree = this._qlParser.type();
        return this._parseTree;
    }
}
