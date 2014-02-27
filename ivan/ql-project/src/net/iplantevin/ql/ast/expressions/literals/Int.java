package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author Ivan
 *         Integer.
 */
public class Int extends Expression {
    private final Integer value;

    public Int(Integer value, ParserRuleContext ctx) {
        super(ctx);
        this.value = value;
    }

    @Override
    public Type getType(TypeEnvironment idTypeMap) {
        return new IntegerType();
    }

    public int getValue() {
        return value.intValue();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
