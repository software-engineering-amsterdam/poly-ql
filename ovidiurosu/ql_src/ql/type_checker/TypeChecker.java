package ql.type_checker;

import java.util.ArrayList;
import java.util.List;

import ql.ast.Questionnaire;
import ql.ast.QuestionnaireList;
import ql.error.IError;

/**
 * @author orosu
 */
public class TypeChecker
{
    private final List<Questionnaire> _questionnaires;

    public TypeChecker(QuestionnaireList questionnaires)
    {
        this._questionnaires = questionnaires.getQuestionnaires();
    }

    public void check()
    {
        List<Questionnaire> checkedQuestionnaires = new ArrayList<Questionnaire>();
        for (Questionnaire questionnaire: this._questionnaires) {
            this.checkQuestionnaire(questionnaire, checkedQuestionnaires);
            checkedQuestionnaires.add(questionnaire);
        }
    }

    public void checkQuestionnaire(Questionnaire questionnaire,
        List<Questionnaire> checkedQuestionnaires)
    {
        TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor(checkedQuestionnaires);
        typeCheckerVisitor.visit(questionnaire);

        // Loop through errors
        for (IError error: typeCheckerVisitor.getErrors()) {
            System.err.println(error.getMessage());
        }
    }
}
