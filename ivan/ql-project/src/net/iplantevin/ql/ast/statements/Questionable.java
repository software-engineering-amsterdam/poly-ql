package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.types.Type;

/**
 * Questionable. Parent class for questions and computed questions.
 *
 * @author Ivan
 */
public abstract class Questionable extends Statement {
    private final ID identifier;
    private final Str label;
    private final Type type;

    protected Questionable(ID identifier, Str label, Type type, LineInfo lineInfo) {
        super(lineInfo);
        this.identifier = identifier;
        this.label = label;
        this.type = type;
    }

    public ID getIdentifier() {
        return identifier;
    }

    public Str getLabel() {
        return label;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return identifier + ": " + label + " " + type;
    }
}
