package ql.type_checker;

import ql.ast.Questionnaire;
import ql.error.Notice;

/**
 * @author orosu
 */
public class QuestionnaireListChecker extends Checker
{
    private final Questionnaire _questionnaire;

    public QuestionnaireListChecker(TypeEnvironment typeEnvironment,
        Questionnaire questionnaire)
    {
        this._typeEnvironment = typeEnvironment;
        this._questionnaire = questionnaire;
    }

    /**
     * Check if the ID of this questionnaire is unique
     */
    public void checkIdForDuplicates()
    {
        for (Questionnaire questionnaireL: this._typeEnvironment.getCheckedQuestionnaires()) {
            if (questionnaireL.getId().equals(this._questionnaire.getId()) &&
                questionnaireL != this._questionnaire) {

                //NOTICE This questionnaire ID is not unique
                this._typeEnvironment.addError(
                    new Notice("This Questionnaire ID ('" +
                        this._questionnaire.getId() + "') is not unique!")
                );
            }
        }
    }
}
