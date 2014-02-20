package nl.uva.polyql.model.expressions;

import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;

public abstract class Expression {

    public abstract Type getReturnType();

    public abstract Object getValue();

    public boolean getBooleanValue() {
        return (Boolean) getValue();
    }

    public double getNumberValue() {
        return (Double) getValue();
    }

    public abstract Set<Question> getReferencedQuestions();
}
