package ql.ast;

import java.util.ArrayList;
import java.util.List;

import ql.ast.visitor_elements.IElement;

/**
 * @author orosu
 */
public class QuestionnaireList implements IElement
{
    private final List<Questionnaire> _questionnaires;

    public QuestionnaireList()
    {
        this._questionnaires = new ArrayList<Questionnaire>();
    }

    public void addQuestionnaire(Questionnaire questionnaire)
    {
        this._questionnaires.add(questionnaire);
    }

    public List<Questionnaire> getQuestionnaires()
    {
        return this._questionnaires;
    }
}
