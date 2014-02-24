package ql.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * QL Questionnaire List
 * @author orosu
 */
public class QuestionnaireList
{
    /**
     * List of QL Questionnaires
     */
    private final List<Questionnaire> _questionnaires;

    /**
     * Constructor
     */
    public QuestionnaireList()
    {
        this._questionnaires = new ArrayList<Questionnaire>();
    }

    /**
     * Add Questionnaire
     * @param questionnaire
     */
    public void addQuestionnaire(Questionnaire questionnaire)
    {
        this._questionnaires.add(questionnaire);
    }

    /**
     * Get Questionnaire List
     * @return the _questionnaires
     */
    public List<Questionnaire> getQuestionnaires()
    {
        return _questionnaires;
    }
}
