package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.visitors.IStatementVisitor;

/**
 * Main statement abstract class. Extended by all kinds of statements.
 *
 * @author Ivan
 */
public abstract class Statement extends ASTNode {
    public Statement(LineInfo lineInfo) {
        super(lineInfo);
    }

    public abstract <T> T accept(IStatementVisitor<T> visitor);
}
