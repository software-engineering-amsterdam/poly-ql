package nl.uva.polyql.model;

import java.util.ArrayList;
import java.util.List;

import nl.uva.polyql.model.expressions.IExpression;

public class IfStatement implements IRule {

    public IExpression mExpression;

    public List<IRule> mRules = new ArrayList<>();

    public void setExpression(final IExpression expression) {

    }

    public void addRule(final IRule rule) {
        mRules.add(rule);
    }

    public List<IRule> getRules() {
        return mRules;
    }
    
    @Override
    public String getId() {
        return null;
    }

}
