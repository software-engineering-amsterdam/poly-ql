package ql.gui.renderer;

import java.util.Iterator;

import ql.ast.Questionnaire;
import ql.ast.QuestionnaireList;
import ql.ast.expression_evaluator.ValueEnvironment;
import ql.ast.statement.IStatement;
import ql.gui.QuestionnaireFrame;

/**
 * @author orosu
 */
public class GuiRenderer
{
    private final QuestionnaireList _questionnaireList;

    public GuiRenderer(QuestionnaireList questionnaireList)
    {
        this._questionnaireList = questionnaireList;
    }

    public QuestionnaireList getQuestionnaireList()
    {
        return this._questionnaireList;
    }

    public void removeQuestionnaire(Questionnaire questionnaire)
    {
        this._questionnaireList.remove(questionnaire);
    }

    public void render()
    {
        Iterator<Questionnaire> iterator = this._questionnaireList.iterator();
        while (iterator.hasNext()) {
            this._renderQuestionnaire(iterator.next());
        }
    }

    private void _renderQuestionnaire(Questionnaire questionnaire)
    {
        QuestionnaireFrame questionnaireFrame = new QuestionnaireFrame(questionnaire, this);
        ValueEnvironment valueEnvironment = new ValueEnvironment();

        Iterator<IStatement> iterator = questionnaire.getStatementList().iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(new GuiRendererVisitor(questionnaireFrame, valueEnvironment));
        }

        questionnaireFrame.build();
        questionnaireFrame.setVisible(true);
    }
}
