package ql.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ql.ast.visitor_elements.IElement;

/**
 * @author orosu
 */
public class QuestionnaireList implements IElement
{
    private final List<Questionnaire> _value;

    public QuestionnaireList()
    {
        this._value = new ArrayList<Questionnaire>();
    }

    public Iterator<Questionnaire> iterator()
    {
        return this._value.iterator();
    }

    public void add(Questionnaire questionnaire)
    {
        this._value.add(questionnaire);
    }

    public void remove(Questionnaire questionnaire)
    {
        this._value.remove(questionnaire);
    }

    public int size()
    {
        return this._value.size();
    }

    @Override
    public String toString()
    {
        String string = "(forms";
        for (Questionnaire questionnaire: this._value) {
            string += " " + questionnaire.toString();
        }
        return string + ")";
    }
}
