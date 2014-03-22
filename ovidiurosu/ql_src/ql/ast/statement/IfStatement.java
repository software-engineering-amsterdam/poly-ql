package ql.ast.statement;

import ql.ast.expression.IExpression;
import ql.ast.type.BooleanType;
import ql.ast.visitor_elements.IStatementElementVisitor;

/**
 * @author orosu
 */
public class IfStatement implements IStatement
{
    private final IExpression _expression;
    private final Block _ifBlock;
    private final Block _elseBlock;

    public IfStatement(IExpression expression, Block ifBlock, Block elseBlock)
    {
        this._expression = expression;
        this._ifBlock = ifBlock;
        this._elseBlock = elseBlock;
    }

    public IExpression getExpression()
    {
        return this._expression;
    }

    public StatementList getIfStatementList()
    {
        return this._ifBlock.getStatementList();
    }

    public StatementList getElseStatementList()
    {
        return this._elseBlock.getStatementList();
    }

    @Override
    public BooleanType getType()
    {
        return new BooleanType();
    }

    @Override
    public String toString()
    {
        return "(statement if ( " + this._expression.toString() + " ) " + this._ifBlock.toString() +
           (this._elseBlock.getStatementList().size() > 0 ? " else " + this._elseBlock.toString() : "") + ")";
    }

    @Override
    public <T> T accept(IStatementElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
