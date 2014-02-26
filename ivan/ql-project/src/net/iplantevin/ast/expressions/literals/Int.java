package net.iplantevin.ast.expressions.literals;

import net.iplantevin.ast.expressions.Expression;
import net.iplantevin.ast.types.IntegerType;
import net.iplantevin.ast.types.Type;
import net.iplantevin.ast.types.TypeEnvironment;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
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
