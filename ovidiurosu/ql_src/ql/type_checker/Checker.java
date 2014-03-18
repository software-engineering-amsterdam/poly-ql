package ql.type_checker;

import java.util.ArrayList;
import java.util.List;

import ql.ast.Questionnaire;

/**
 * @author orosu
 */
public abstract class Checker
{
    protected TypeEnvironment _typeEnvironment;

    public Checker()
    {
        this._typeEnvironment = new TypeEnvironment(new ArrayList<Questionnaire>());
    }

    public Checker(List<Questionnaire> checkedQuestionnaires)
    {
        this._typeEnvironment = new TypeEnvironment(checkedQuestionnaires);
    }
}
