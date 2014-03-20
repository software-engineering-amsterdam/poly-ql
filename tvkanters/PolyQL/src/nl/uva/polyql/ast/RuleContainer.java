package nl.uva.polyql.ast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import nl.uva.polyql.ast.expressions.Expression;

public abstract class RuleContainer {

    private final List<Rule> mRules = new LinkedList<>();
    private final List<RuleContainer> mRuleContainers = new LinkedList<>();
    private final Map<String, Question> mQuestions = new HashMap<>();

    public Question addQuestion(final String id, final String content, final String type) {
        final Question question = new Question(id, content, type);
        addQuestion(question);
        return question;
    }

    public CalculatedQuestion addCalculatedQuestion(final String id, final String content, final String type,
            final Expression expression) {
        final CalculatedQuestion calculatedQuestion = new CalculatedQuestion(id, content, type, expression);
        addQuestion(calculatedQuestion);
        return calculatedQuestion;
    }

    private void addQuestion(final Question question) {
        mQuestions.put(question.getId(), question);
        mRules.add(question);
    }

    public IfStatement addIfStatement(final Expression expression) {
        final IfStatement child = new IfStatement(this, expression);
        mRuleContainers.add(child);
        mRules.add(child);
        return child;
    }

    public ElseStatement addElseStatement(final Expression expression) {
        final ElseStatement child = new ElseStatement(this, expression);
        mRuleContainers.add(child);
        mRules.add(child);
        return child;
    }

    /**
     * Retrieves the list of rules within this container. Does not include the parent's rules.
     * 
     * @return This container's rules
     */
    public List<Rule> getRules() {
        return mRules;
    }

    /**
     * Retrieves all rules within this container and its children containers.
     * 
     * @return All questions in the hierarchy
     */
    public List<Question> getQuestionsRecursively() {
        final List<Question> questions = new LinkedList<>();
        questions.addAll(mQuestions.values());

        for (final RuleContainer container : mRuleContainers) {
            questions.addAll(container.getQuestionsRecursively());
        }

        return questions;
    }

    /**
     * Finds a question based on the ID through a recursive upward search. Doesn't find questions
     * defined in scopes that sibling this container's hierarchy.
     * 
     * @param id
     *            The question ID to find
     * 
     * @return The question matching the given ID or null if it wasn't found
     */
    public Question getQuestion(final String id) {
        if (mQuestions.containsKey(id)) {
            return mQuestions.get(id);
        }

        final RuleContainer parent = getParent();
        if (parent != null) {
            return parent.getQuestion(id);
        }

        return null;
    }

    /**
     * Can be override to supply a parent.
     * 
     * @return null by default, or a parent when overridden
     */
    public RuleContainer getParent() {
        return null;
    }

}
