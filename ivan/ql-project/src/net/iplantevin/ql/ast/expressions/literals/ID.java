package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author  Ivan
 * Identifier.
 */
public class ID extends Expression {
    private final String name;

    public ID(String name, ParserRuleContext ctx) {
        super(ctx);
        this.name = name;
    }

    public ID(String name, LineInfo lineInfo) {
        super(lineInfo);
        this.name = name;
    }

    @Override
    public Type getType(TypeEnvironment idTypeEnv) {
        return idTypeEnv.getDeclaredType(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
