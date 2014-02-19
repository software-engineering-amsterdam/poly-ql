package nl.uva.polyql.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Form {

    public List<IRule> mRules = new ArrayList<>();
    public Map<String, IRule> mIdRules = new HashMap<>();

    public void addRule(final IRule rule) {
        final String id = rule.getId();
        if (id != null) {
            if (mIdRules.containsKey(id)) {
                throw new RuntimeException("Duplicate rule ID");
            }

            mIdRules.put(id, rule);
        }

        mRules.add(rule);
    }

    public List<IRule> getRules() {
        return mRules;
    }

}
