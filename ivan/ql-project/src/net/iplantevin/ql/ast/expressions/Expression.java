package net.iplantevin.ql.ast.expressions;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Abstract Expression class that implements the ASTNode interface. All kinds
 * of expressions must extend this class or a subclass of it.
 *
 * @author Ivan
 */
public abstract class Expression extends ASTNode {
    public Expression(ParserRuleContext ctx) {
        super(ctx);
    }

    public Expression(LineInfo lineInfo) {
        super(lineInfo);
    }

    public abstract Type getType(TypeEnvironment idTypeStore);
}
