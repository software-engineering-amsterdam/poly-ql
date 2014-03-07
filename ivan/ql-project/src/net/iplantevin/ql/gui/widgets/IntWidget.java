package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.evaluation.IntVal;

import javax.swing.*;

/**
 * @author Ivan
 */
public class IntWidget extends JSpinner {
    public IntWidget(WidgetContainer container) {
        super(new SpinnerNumberModel(0, 0, 1000000000, 1));
        setPreferredSize(container.getWidgetSize());
        setMaximumSize(container.getWidgetSize());

        container.setValue(new IntVal(0));

        configureListener(container);
    }

    private void configureListener(WidgetContainer container) {

    }
}
