package nl.uva.polyql.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.uva.polyql.model.expressions.Expression;

public abstract class RuleContainer extends Rule {

    private final List<Rule> mRules = new ArrayList<>();
    private final Map<String, Question> mQuestions = new HashMap<>();

    protected RuleContainer(final RuleContainer parent) {
        super(parent);
    }

    public Question addQuestion(final String id, final String content, final String type) {
        final Question question = new Question(this, id, content, type);
        addQuestion(question);
        return question;
    }

    public Field addField(final String id, final String content, final Expression expression) {
        final Field field = new Field(this, id, content, expression);
        addQuestion(field);
        return field;
    }

    private void addQuestion(final Question question) {
        mQuestions.put(question.getId(), question);
        mRules.add(question);

        addLabel(question.getContent());
    }

    public IfStatement addIfStatement(final Expression expression) {
        final IfStatement child = new IfStatement(this, expression);
        mRules.add(child);
        return child;
    }

    public IfStatement addElseStatement(final Expression expression) {
        final IfStatement child = new ElseStatement(this, expression);
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

    public abstract boolean addLabel(String label);

}