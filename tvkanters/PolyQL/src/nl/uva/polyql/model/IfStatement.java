package nl.uva.polyql.model;

import java.util.ArrayList;
import java.util.List;

import nl.uva.polyql.model.expressions.Expression;

public class IfStatement implements Rule {

    public Expression mExpression;

    public List<Rule> mRules = new ArrayList<>();

    public void setExpression(final Expression expression) {

    }

    public void addRule(final Rule rule) {
        mRules.add(rule);
    }

    public List<Rule> getRules() {
        return mRules;
    }
    
    @Override
    public String getId() {
        return null;
    }

}
