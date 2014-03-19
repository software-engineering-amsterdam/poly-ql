package ql.gui.renderer;

import java.util.List;

import ql.ast.Questionnaire;

/**
 * @author orosu
 */
public class GuiRenderer
{
    private final List<Questionnaire> _questionnaires;

    public GuiRenderer(List<Questionnaire> questionnaires)
    {
        this._questionnaires = questionnaires;
    }

    public List<Questionnaire> getQuestionnaires()
    {
        return this._questionnaires;
    }

    public void removeQuestionnaire(Questionnaire questionnaire)
    {
        this._questionnaires.remove(questionnaire);
    }

    public void render()
    {
        GuiRendererVisitor guiRenderrerVisitor;

        for (Questionnaire questionnaire: this._questionnaires) {
            guiRenderrerVisitor = new GuiRendererVisitor(this);
            guiRenderrerVisitor.visit(questionnaire)
                .setVisible(true);
        }
    }
}
