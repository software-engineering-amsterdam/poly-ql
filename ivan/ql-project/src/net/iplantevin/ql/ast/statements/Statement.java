package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.ASTNode;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Main statement abstract class. Extended by all kinds of statements.
 *
 * @author Ivan
 */
public abstract class Statement extends ASTNode {
    public Statement(ParserRuleContext ctx) {
        super(ctx);
    }
}
