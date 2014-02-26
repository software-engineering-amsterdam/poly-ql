package net.iplantevin.ast.statements;

import net.iplantevin.ast.QLASTNode;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * Main statement abstract class. Extended by all kinds of statements.
 */
public abstract class Statement extends QLASTNode {
    public Statement(ParserRuleContext ctx) {
        super(ctx);
    }
}
