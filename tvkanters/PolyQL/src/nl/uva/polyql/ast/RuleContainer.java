package nl.uva.polyql.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import nl.uva.polyql.ast.expressions.Expression;

public abstract class RuleContainer {

    private final List<Rule> mChildRules = new ArrayList<>();
    private final Map<String, Question> mQuestions = new HashMap<>();

    public Question addQuestion(final String id, final String content, final String type) {
        final Question question = new Question(this, id, content, type);
        addQuestion(question);
        return question;
    }

    public CalculatedQuestion addCalculatedQuestion(final String id, final String content, final String type,
            final Expression expression) {
        final CalculatedQuestion calculatedQuestion = new CalculatedQuestion(this, id, content, type, expression);
        addQuestion(calculatedQuestion);
        return calculatedQuestion;
    }

    private void addQuestion(final Question question) {
        mQuestions.put(question.getId(), question);
        mChildRules.add(question);
    }

    public IfStatement addIfStatement(final Expression expression) {
        final IfStatement child = new IfStatement(this, expression);
        mChildRules.add(child);
        return child;
    }

    public ElseStatement addElseStatement(final Expression expression) {
        final ElseStatement child = new ElseStatement(this, expression);
        mChildRules.add(child);
        return child;
    }

    /**
     * Retrieves the list of rules within this container. Does not include the parent's rules.
     * 
     * @return This container's rules
     */
    public List<Rule> getChildRules() {
        return mChildRules;
    }

    public List<Question> getQuestions() {
        final List<Question> questions = new LinkedList<>();
        for (final Rule rule : mChildRules) {
            questions.addAll(rule.getQuestions());
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

    public RuleContainer getParent() {
        return null;
    }

}
