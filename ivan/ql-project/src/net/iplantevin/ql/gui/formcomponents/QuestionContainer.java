package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.gui.main.FormFrame;

import javax.swing.*;

/**
 * @author Ivan
 */
public class QuestionContainer extends AbstractWidgetContainer {
    public QuestionContainer(String identifier, String labelText, FormFrame formFrame) {
        super(identifier, labelText, formFrame);
    }

    public void initUIWithWidget(JComponent widget) {
        setWidget(widget);
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
