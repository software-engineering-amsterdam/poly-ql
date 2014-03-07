package nl.uva.polyql.model.expressions;

import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;

public abstract class Expression {

    public abstract Type getReturnType();

    public abstract Value<?> getValue();

    /**
     * Retrieves all questions that are referenced by this expression. E.g., '(num + 2)' refers to
     * the question with ID 'num'.
     * 
     * @return The questions that this expression references, may never return null
     */
    public abstract Set<Question> getReferencedQuestions();
}
