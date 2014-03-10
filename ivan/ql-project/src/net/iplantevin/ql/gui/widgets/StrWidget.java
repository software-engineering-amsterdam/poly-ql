package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.evaluation.StrVal;

import javax.swing.*;

/**
 * @author Ivan
 */
public class StrWidget extends JTextField {
    public StrWidget(WidgetContainer container) {
        setPreferredSize(container.getWidgetSize());
        setMaximumSize(container.getWidgetSize());

        container.setValue(new StrVal(""));

        configureListener(container);
    }

    private void configureListener(WidgetContainer container) {

    }
}
