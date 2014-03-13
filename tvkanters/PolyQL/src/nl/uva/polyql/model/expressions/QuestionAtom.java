package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.RuleContainer;
import nl.uva.polyql.model.expressions.modifiers.Modifier;
import nl.uva.polyql.model.expressions.modifiers.ModifierHelper;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.Value;
import nl.uva.polyql.validation.UnknownIdError;
import nl.uva.polyql.validation.ValidationErrors;

public class QuestionAtom extends Expression {

    private final String mQuestionId;
    private final Question mQuestion;
    private final Modifier<?> mModifier;

    public QuestionAtom(final RuleContainer parentRuleContainer, final String id, final String modifier) {
        mQuestionId = id;
        mQuestion = parentRuleContainer.getQuestion(id);
        mModifier = ModifierHelper.getBySyntax(modifier);
        if (mQuestion != null) {
            if (!mModifier.isValid(mQuestion.getType())) {
                // TODO: Invalid modifier
            }
        }
    }

    public String getId() {
        return mQuestionId;
    }

    @Override
    public Type getReturnType() {
        return mQuestion.getType();
    }

    @Override
    public Value<?> getValue() {
        return mQuestion.getValue().applyModifier(mModifier);
    }

    @Override
    public String toString() {
        return mModifier.getSyntax() + mQuestion.getId() + " = " + getValue();
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        final Set<Question> questions = new HashSet<>();
        questions.add(mQuestion);
        return questions;
    }

    @Override
    public ValidationErrors validate() {
        final ValidationErrors errors = new ValidationErrors();
        if (mQuestion == null) {
            errors.add(new UnknownIdError(this));
        }
        return errors;
    }

    @Override
    public boolean isValid() {
        return getReturnType() != Type.INVALID;
    }
}
