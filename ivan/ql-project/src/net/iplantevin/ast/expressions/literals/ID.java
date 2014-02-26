package net.iplantevin.ast.expressions.literals;

import net.iplantevin.ast.LineInfo;
import net.iplantevin.ast.expressions.Expression;
import net.iplantevin.ast.types.Type;
import net.iplantevin.ast.types.TypeEnvironment;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
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
