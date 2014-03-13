package net.iplantevin.ql.ast.visitors;

import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;

/**
 * @author Ivan
 */
public interface IStatementVisitor<T> {
    public T visit(Block block);

    public T visit(Computation computation);

    public T visit(If ifStat);

    public T visit(IfElse ifElse);

    public T visit(Question question);
}
