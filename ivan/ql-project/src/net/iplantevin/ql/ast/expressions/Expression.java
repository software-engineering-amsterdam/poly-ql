package net.iplantevin.ql.ast.expressions;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.QLASTNode;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author Ivan
 *         Abstract Expression class that implements the QLASTNode interface. All kinds
 *         of expressions must extend this class or a subclass of it.
 */
public abstract class Expression extends QLASTNode {
    public Expression(ParserRuleContext ctx) {
        super(ctx);
    }

    public Expression(LineInfo lineInfo) {
        super(lineInfo);
    }

    public abstract Type getType(TypeEnvironment idTypeMap);
}
