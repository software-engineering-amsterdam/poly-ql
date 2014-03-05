package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

/**
 * Integer.
 *
 * @author Ivan
 */
public class Int extends Expression {
    private final Integer value;

    public Int(Integer value, LineInfo lineInfo) {
        super(lineInfo);
        this.value = value;
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
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
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
