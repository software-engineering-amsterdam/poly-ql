package ql.type_checker;

import java.util.Iterator;

import ql.ast.Questionnaire;
import ql.ast.QuestionnaireList;
import ql.error.IError;

/**
 * @author orosu
 */
//TODO maybe improve error messages' text
public class TypeChecker
{
    private final QuestionnaireList _questionnaireList;

    public TypeChecker(QuestionnaireList questionnaireList)
    {
        this._questionnaireList = questionnaireList;
    }

    public void check()
    {
        QuestionnaireList checkedQuestionnaires = new QuestionnaireList();

        Iterator<Questionnaire> iterator = this._questionnaireList.iterator();
        while(iterator.hasNext()) {
            Questionnaire questionnaire = iterator.next();
            this.checkQuestionnaire(questionnaire, checkedQuestionnaires);
            checkedQuestionnaires.add(questionnaire);
        }
    }

    public void checkQuestionnaire(Questionnaire questionnaire,
        QuestionnaireList checkedQuestionnaires)
    {
        TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor(checkedQuestionnaires);
        typeCheckerVisitor.visit(questionnaire);

        // Loop through errors and display them
        Iterator<IError> iterator = typeCheckerVisitor.getErrorList().iterator();
        while (iterator.hasNext()) {
            System.err.println(iterator.next().getMessage());
        }
    }
}
