package nl.uva.polyql.ast.expressions;

import java.util.Set;

import nl.uva.polyql.ast.AstComponent;
import nl.uva.polyql.ast.LineInfo;
import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.values.Type;
import nl.uva.polyql.ast.values.Value;
import nl.uva.polyql.validation.ValidationErrors;

public abstract class Expression implements AstComponent {

    private LineInfo mLineInfo;

    public abstract Type getReturnType();

    public abstract Value<?> getValue();

    /**
     * Retrieves all questions that are referenced by this expression. E.g., '(num + 2)' refers to
     * the question with ID 'num'.
     * 
     * @return The questions that this expression references, may never return null
     */
    public abstract Set<Question> getReferencedQuestions();

    public abstract ValidationErrors validate();

    public boolean isValid() {
        return true;
    }

    @Override
    public void setLineInfo(final LineInfo lineInfo) {
        mLineInfo = lineInfo;
    }

    @Override
    public LineInfo getLineInfo() {
        return mLineInfo;
    }

}
