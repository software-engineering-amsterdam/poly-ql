package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.QLASTNode;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author Ivan
 *         Main statement abstract class. Extended by all kinds of statements.
 */
public abstract class Statement extends QLASTNode {
    public Statement(ParserRuleContext ctx) {
        super(ctx);
    }
}
