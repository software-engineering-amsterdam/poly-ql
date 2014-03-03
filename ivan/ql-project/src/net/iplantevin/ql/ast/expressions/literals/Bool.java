package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Boolean.
 *
 * @author Ivan
 */
public class Bool extends Expression {
    private final Boolean value;

    public Bool(boolean value, ParserRuleContext ctx) {
        super(ctx);
        this.value = value;
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return new BooleanType();
    }

    public boolean getValue() {
        return value.booleanValue();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
