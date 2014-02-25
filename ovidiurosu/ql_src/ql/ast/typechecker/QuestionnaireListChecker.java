package ql.ast.typechecker;

import ql.ast.Questionnaire;
import ql.exc.NoticeExc;

/**
 * Questionnaire List Checker
 * @author orosu
 */
public class QuestionnaireListChecker implements IChecker
{
    /**
     * AST Type Checker Visitor
     */
    private final TypeCheckerVisitor _visitor;

    /**
     * Questionnaire
     */
    private final Questionnaire _questionnaire;

    /**
     * Constructor
     */
    public QuestionnaireListChecker(TypeCheckerVisitor visitor,
        Questionnaire questionnaire
    ) {
        this._visitor = visitor;
        this._questionnaire = questionnaire;
    }

    /**
     * Check if the ID of this questionnaire is unique
     */
    public void checkIdForDuplicates()
    {
        for (Questionnaire questionnaireL: this._visitor.getCheckedQuestionnaires()) {
            if (questionnaireL.getId().equals(this._questionnaire.getId()) &&
                questionnaireL != this._questionnaire) {

                //NOTICE This questionnaire ID is not unique
                this._visitor.addExc(
                    new NoticeExc("This Questionnaire ID ('" +
                        this._questionnaire.getId() + "') is not unique!")
                );
            }
        }
    }

}
