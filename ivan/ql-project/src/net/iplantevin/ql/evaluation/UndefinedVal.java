package net.iplantevin.ql.evaluation;

/**
 * @author Ivan
 */
public class UndefinedVal extends Value {
    public UndefinedVal getValue() {
        return new UndefinedVal();
    }
}
