package ql.ast.statement;

import java.util.List;

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

    public IfStatement(IExpression expression,
            Block ifBlock, Block elseBlock)
    {
        this._expression = expression;
        this._ifBlock = ifBlock;
        this._elseBlock = elseBlock;
    }

    public IExpression getExpression()
    {
        return this._expression;
    }

    public List<IStatement> getIfStatements()
    {
        return this._ifBlock.statements;
    }

    public List<IStatement> getElseStatements()
    {
        return this._elseBlock.statements;
    }

    @Override
    public BooleanType getType()
    {
        return new BooleanType();
    }

    @Override
    public <T> T accept(IStatementElementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
