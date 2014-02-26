package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * String.
 */
public class Str extends Expression {
    private final String text;

    public Str(String text, ParserRuleContext ctx) {
        super(ctx);
        this.text = text;
    }

    public Str(String text, LineInfo lineInfo) {
        super(lineInfo);
        this.text = text;
    }

    @Override
    public Type getType(TypeEnvironment idTypeMap) {
        return new StringType();
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
