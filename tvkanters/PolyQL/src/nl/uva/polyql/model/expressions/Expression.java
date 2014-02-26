package nl.uva.polyql.model.expressions;

import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

public abstract class Expression {

    public abstract Type getReturnType();

    public abstract Value<?> getValue();

    public abstract Set<Question> getReferencedQuestions();
}
