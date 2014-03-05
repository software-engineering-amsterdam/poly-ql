package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

import java.util.ArrayList;

/**
 * Block: a list of statements.
 *
 * @author Ivan
 */
public class Block extends Statement {
    private final ArrayList<Statement> statements;

    public Block(ArrayList<Statement> statements, LineInfo lineInfo) {
        super(lineInfo);
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
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
