package ql.ast.statement;

import java.util.Iterator;

import ql.ast.visitor_elements.IElement;

/**
 * @author orosu
 */
public class Block implements IElement
{
    private final StatementList _statementList;

    public Block(StatementList statementList)
    {
        this._statementList = statementList;
    }

    public StatementList getStatementList()
    {
        return this._statementList;
    }

    @Override
    public String toString()
    {
        String string = "(block {";
        Iterator<IStatement> statementListIterator = this.getStatementList().iterator();
        while (statementListIterator.hasNext()) {
            string += " " + statementListIterator.next().toString();
        }
        return string + " })";
    }
}
