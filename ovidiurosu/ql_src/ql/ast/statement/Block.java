package ql.ast.statement;

import java.util.List;

import ql.ast.visitor_elements.IElement;

/**
 * @author orosu
 */
public class Block implements IElement
{
    public List<IStatement> statements;
    public Block(List<IStatement> statements)
    {
        this.statements = statements;
    }
}
