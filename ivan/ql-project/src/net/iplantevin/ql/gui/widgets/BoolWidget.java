package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.evaluation.BoolVal;

import javax.swing.*;

/**
 * @author Ivan
 */
public class BoolWidget extends JCheckBox {
    public BoolWidget(WidgetContainer container) {
        super("Yes/no");
        setPreferredSize(container.getWidgetSize());
        setMaximumSize(container.getWidgetSize());

        container.setValue(new BoolVal(false));

        configureListener(container);
    }

    private void configureListener(WidgetContainer container) {

    }
}
