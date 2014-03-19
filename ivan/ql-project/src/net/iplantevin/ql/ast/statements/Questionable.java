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
    private final ID name;
    private final Str label;
    private final Type type;

    protected Questionable(ID name, Str label, Type type, LineInfo lineInfo) {
        super(lineInfo);
        this.name = name;
        this.label = label;
        this.type = type;
    }

    public ID getName() {
        return name;
    }

    public Str getLabel() {
        return label;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + ": " + label + " " + type;
    }
}
