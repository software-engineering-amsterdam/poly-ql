package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.gui.main.FormFrame;

/**
 * @author Ivan
 */
public class QuestionContainer extends AbstractWidgetContainer {
    public QuestionContainer(Question question, FormFrame formFrame) {
        super(question, formFrame);
        setWidget(TypeToWidget.makeWidget(question.getType(), this));
        initUI();
    }

    @Override
    public void reEvaluate() {
        if (!isActive()) {
            return;
        }
        getFormFrame().registerValueChange(this, getValue());
    }
}
