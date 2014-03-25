package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.evaluation.IntVal;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * An IntWidget is a JSpinner that implements the necessary FormFrame functionality.
 *
 * @author Ivan
 */
public class IntWidget extends JSpinner implements IWidget {
    /**
     * Constructs a new JSpinner with a SpinnerNumberModel and the given
     * AbstractWidgetContainer for UI and listener setup.
     *
     * @param container the AbstractWidgetContainer to use for the listener and UI setup.
     */
    public IntWidget(AbstractWidgetContainer container) {
        super(new SpinnerNumberModel(0, 0, 1000000000, 1));
        setPreferredSize(container.getPreferredWidgetSize());
        setMaximumSize(container.getPreferredWidgetSize());

        container.setValue(new IntVal(0));

        addChangeListener(new IntWidgetListener(this, container));
    }

    @Override
    public void setJComponentValue(Object value) {
    }

    @Override
    public void setDefaultValue(AbstractWidgetContainer container) {
        setValue(0);
        container.setValue(new IntVal(0));
    }

    /**
     * Listener that listens to ChangeEvents. Notifies the AbstractWidgetContainer of
     * changes.
     */
    class IntWidgetListener implements ChangeListener {
        final IntWidget widget;
        final AbstractWidgetContainer container;

        public IntWidgetListener(IntWidget widget, AbstractWidgetContainer container) {
            this.widget = widget;
            this.container = container;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Integer value = (Integer) widget.getValue();
            container.setValue(new IntVal(value));
            container.reEvaluate();
        }
    }
}
