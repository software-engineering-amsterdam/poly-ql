package nl.uva.polyql.model;

import java.util.ArrayList;
import java.util.List;

public class Form {

    public List<Rule> mRules = new ArrayList<>();

    public void addQuestion(final Rule rule) {
        mRules.add(rule);
    }

    public List<Rule> getRules() {
        return mRules;
    }

}
