package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.evaluation.UndefinedVal;

import javax.swing.*;

/**
 * JLabel that represents the widget for a Computation.
 *
 * @author Ivan
 */
public class CompWidget extends JLabel implements IWidget {
    /**
     * Constructs a CompWidget according to the settings in the given
     * AbstractWidgetContainer.
     *
     * @param container AbstractWidgetContainer from which to get settings.
     */
    public CompWidget(AbstractWidgetContainer container) {
        setPreferredSize(container.getPreferredWidgetSize());
        setMaximumSize(container.getPreferredWidgetSize());
    }

    @Override
    public void setJComponentValue(Object value) {
        setText(value.toString());
    }

    @Override
    public void setDefaultValue(AbstractWidgetContainer container) {
        container.setValue(new UndefinedVal());
        setText("");
    }
}
