package ql.ast;
import ql.ast.statements.*;

import java.util.List;

/**
 * Contains statements.
 */
public class Questionnaire implements EInterface {
    private final String id;
    private final List<SInterface> statements;

    public Questionnaire(String id, List<SInterface> statements)
    {
        this.id = id;
        this.statements = statements;
    }

    // Get ID
    public String getId() {
        return this.id;
    }

    // Get statements
    public List<SInterface> getStats()
    {
        return this.statements;
    }

    @Override
    // Visit
    public void accept(EInterfaceVisitor visitor)
    {
        for(EInterface statement: this.statements) {
            statement.accept(visitor);
        }

        visitor.visit(this);
    }
}