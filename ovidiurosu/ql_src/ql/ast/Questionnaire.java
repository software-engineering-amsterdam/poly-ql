package ql.ast;

import java.util.List;

import ql.ast.statement.Block;
import ql.ast.statement.IStatement;
import ql.ast.visitor_elements.IElement;

/**
 * @author orosu
 */
public class Questionnaire implements IElement
{
    private final String _id;
    private final Block _block;

    public Questionnaire(String id, Block block)
    {
        this._id = id;
        this._block = block;
    }

    public String getId()
    {
        return this._id;
    }

    public List<IStatement> getStatements()
    {
        return this._block.statements;
    }
}
