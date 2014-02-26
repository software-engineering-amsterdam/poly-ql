package net.iplantevin.ast.expressions;

import net.iplantevin.ast.LineInfo;
import net.iplantevin.ast.QLASTNode;
import net.iplantevin.ast.types.Type;
import net.iplantevin.ast.types.TypeEnvironment;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * Abstract Expression class that implements the QLASTNode interface. All kinds
 * of expressions must extend this class or a subclass of it.
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
