package ql.ast;

import ql.ast.statement.Block;
import ql.ast.statement.StatementList;
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

    public StatementList getStatementList()
    {
        return this._block.getStatementList();
    }

    @Override
    public String toString()
    {
        return "(form form " + this._id + " " + this._block.toString() + ")";
    }
}
