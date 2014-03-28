package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.evaluation.StrVal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A JTextField-based widget with an ActionListener implementing the necessary
 * FormFrame actions.
 *
 * @author Ivan
 */
public class StrWidget extends JTextField implements IWidget {
    /**
     * Constructs a default JTextfield with the given container for UI and
     * listener setup.
     *
     * @param container the AbstractWidgetContainer to use for the listener and UI setup.
     */
    public StrWidget(AbstractWidgetContainer container) {
        setPreferredSize(container.getPreferredWidgetSize());
        setMaximumSize(container.getPreferredWidgetSize());

        container.setValue(new StrVal(""));

        addActionListener(new StrWidgetListener(this, container));
    }

    @Override
    public void setJComponentValue(Object value) {
    }

    @Override
    public void setDefaultValue(AbstractWidgetContainer container) {
        setText("");
        container.setValue(new StrVal(""));
    }

    /**
     * Listener that listens to ActionEvents. Notifies the AbstractWidgetContainer of
     * changes.
     */
    class StrWidgetListener implements ActionListener {
        final StrWidget widget;
        final AbstractWidgetContainer container;

        public StrWidgetListener(StrWidget widget, AbstractWidgetContainer container) {
            this.widget = widget;
            this.container = container;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            container.setValue(new StrVal(widget.getText()));
            container.reEvaluate();
        }
    }
}
