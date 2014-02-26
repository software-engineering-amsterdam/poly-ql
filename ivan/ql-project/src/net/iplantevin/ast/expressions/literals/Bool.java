package net.iplantevin.ast.expressions.literals;

import net.iplantevin.ast.expressions.Expression;
import net.iplantevin.ast.types.BooleanType;
import net.iplantevin.ast.types.Type;
import net.iplantevin.ast.types.TypeEnvironment;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * Boolean.
 */
public class Bool extends Expression {
    private final Boolean value;

    public Bool(boolean value, ParserRuleContext ctx) {
        super(ctx);
        this.value = value;
    }

    @Override
    public Type getType(TypeEnvironment idTypeMap) {
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
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
