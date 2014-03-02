package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.visitors.IASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

/**
 * Block: a list of statements.
 *
 * @author Ivan
 */
public class Block extends Statement {
    private final ArrayList<Statement> statements;

    public Block(ArrayList<Statement> statements, ParserRuleContext ctx) {
        super(ctx);
        this.statements = statements;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        String block = "\n{\n";
        for (Statement statement : statements) {
            block += statement.toString();
        }
        block += "}\n";
        return block;
    }

    @Override
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
