package net.iplantevin.ql.ast.form;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

/**
 * Form objects have a name and a block of statements (body).
 *
 * @author Ivan
 */
public class Form extends ASTNode {
    private final String name;
    private final Block body;

    public Form(String name, Block body, LineInfo lineInfo) {
        super(lineInfo);
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
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
