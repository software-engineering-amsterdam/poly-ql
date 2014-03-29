package ql.type_checker;

import java.util.Iterator;

import ql.ast.Questionnaire;
import ql.ast.QuestionnaireList;
import ql.error.ErrorList;
import ql.error.Notice;

/**
 * @author orosu
 */
public class QuestionnaireListChecker extends Checker
{
    private final Questionnaire _questionnaire;
    private final QuestionnaireList _checkedQuestionnaires;

    public QuestionnaireListChecker(TypeEnvironment typeEnvironment, ErrorList errorList,
        Questionnaire questionnaire, QuestionnaireList checkedQuestionnaires)
    {
        super(typeEnvironment, errorList);
        this._questionnaire = questionnaire;
        this._checkedQuestionnaires = checkedQuestionnaires;
    }

    /**
     * Check if the ID of this questionnaire is unique
     */
    public void checkIdForDuplicates()
    {
        Iterator<Questionnaire> iterator = this._checkedQuestionnaires.iterator();
        while (iterator.hasNext()) {
            Questionnaire questionnaire = iterator.next();
            if (!questionnaire.getId().equals(this._questionnaire.getId()) ||
                questionnaire == this._questionnaire)
            {
                continue;
            }

            //NOTICE This questionnaire ID is not unique
            this._errorList.add(
                new Notice("This Questionnaire ID ('" +
                    this._questionnaire.getId() + "') is not unique!")
            );
        }
    }
}
