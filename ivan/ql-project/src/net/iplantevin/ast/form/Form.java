package net.iplantevin.ast.form;

import net.iplantevin.ast.QLASTNode;
import net.iplantevin.ast.statements.Block;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 19-02-14
 * Form objects have a name and a block of statements (body).
 */
public class Form extends QLASTNode {
    private final String name;
    private final Block body;

    public Form(String name, Block body, ParserRuleContext ctx) {
        super(ctx);
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "form " + name + body.toString();
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
